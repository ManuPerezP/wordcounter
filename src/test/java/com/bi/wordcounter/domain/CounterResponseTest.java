package com.bi.wordcounter.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CounterResponseTest {
	CounterResponse cr;
	public static final Ranking ranking = new Ranking();
	public static final List<Ranking> rankingList = new ArrayList<>();

	@Test
	public void domainObjectShouldWork() {
		ranking.setOcurrences(1L);
		ranking.setWord("fulltext");
		rankingList.add(ranking);
		cr = new CounterResponse("1", "title", "fulltext", rankingList);

		assertEquals(cr.getFullText(), "fulltext");

		cr.setFullText("setText");
		cr.setId("di");
		cr.setTitle("title");
		cr.setRanking(rankingList);

		assertEquals(cr.getId(), "di");
		assertEquals(cr.getFullText(), "setText");
		assertEquals(cr.getTitle(), "title");
		assertEquals(cr.getRanking().get(0).getWord(), "fulltext");
	}

}
