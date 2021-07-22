package com.bi.wordcounter.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TextTest {
	Text text;

	@Test
	public void domainObjectShouldWork() {
		text = new Text("id", "title", 1, 1, "text");
		assertEquals(text.getPage(), 1);
		assertTrue(text.toString().contains("id=id"));
	}
}
