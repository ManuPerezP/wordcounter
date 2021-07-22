package com.bi.wordcounter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.bi.wordcounter.domain.CounterResponse;
import com.bi.wordcounter.domain.Ranking;
import com.bi.wordcounter.domain.Text;

@SpringBootTest
public class RankingServiceTest {
	public static final Ranking ranking = new Ranking();
	public static final List<Ranking> rankingList = new ArrayList<>();

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	RankingService rankingService;

	@Before
	public void init() {
		ranking.setOcurrences(1L);
		ranking.setWord("fulltext");
		rankingList.add(ranking);
	}

	@Test
	public void serviceShouldWork() {
		Text text = new Text();
		text.setTitle("Title");
		text.setId("1");
		text.setPage(1);
		text.setText("text");
		text.setTotalPages(2);

		Mockito.when(restTemplate.getForObject("http://localhost:8080/generator/word-counter/text", Text.class))
				.thenReturn(text);
		Mockito.when(
				restTemplate.getForObject("http://localhost:8080/generator/word-counter/text?id=1&&page=2", Text.class))
				.thenReturn(text);
		CounterResponse response = rankingService.getRanking();
		assertEquals(response.getFullText(), "text text");
	}
}
