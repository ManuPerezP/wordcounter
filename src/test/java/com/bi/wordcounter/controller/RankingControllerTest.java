package com.bi.wordcounter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bi.wordcounter.domain.CounterResponse;
import com.bi.wordcounter.domain.Ranking;
import com.bi.wordcounter.service.RankingService;

@SpringBootTest
public class RankingControllerTest {

	public static final Ranking ranking = new Ranking();
	public static final List<Ranking> rankingList = new ArrayList<>();
	public static final RankingService rankingService = Mockito.mock(RankingService.class);

	@InjectMocks
	RankingController rankingController;

	@Test
	public void getRestaurantByIdTest() {
		ranking.setOcurrences(1L);
		ranking.setWord("fulltext");
		rankingList.add(ranking);
		Mockito.when(rankingService.getRanking())
				.thenReturn(new CounterResponse("1", "title", "fulltext", rankingList));
		final CounterResponse response = rankingController.getRanking();
		assertEquals(response.getFullText(), "fulltext");
	}
}
