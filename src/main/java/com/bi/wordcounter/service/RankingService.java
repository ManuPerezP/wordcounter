package com.bi.wordcounter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bi.wordcounter.domain.CounterResponse;
import com.bi.wordcounter.domain.Ranking;
import com.bi.wordcounter.domain.Text;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RankingService {

	@Autowired
	RestTemplate restTemplate;

	public CounterResponse getRanking() {

		String allText = "";
		Text page;

		Text text = restTemplate.getForObject("http://localhost:8080/generator/word-counter/text", Text.class);
		allText = text.getText();

		for (int i = 2; i <= text.getTotalPages(); i++) {
			page = restTemplate.getForObject(
					"http://localhost:8080/generator/word-counter/text?id=" + text.getId() + "&&page=" + i, Text.class);
			allText = allText + " " + page.getText();
		}

		List<String> itemsList = removeSpecialCharactersAndConvert(allText);

		Map<String, Long> result = makeRankingListMap(itemsList);

		return new CounterResponse(text.getId(), text.getTitle(), allText, SortAndList(result));
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private List<String> removeSpecialCharactersAndConvert(String string) {
		return Arrays.asList(string.replaceAll("[,.:;-]", "").split(" "));
	}

	private Map<String, Long> makeRankingListMap(List<String> list) {
		return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	private List<Ranking> SortAndList(Map<String, Long> result) {
		List<Ranking> rankingList = new ArrayList<Ranking>();
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> rankingList.add(new Ranking(e.getKey(), e.getValue())));
		return rankingList;
	}

}
