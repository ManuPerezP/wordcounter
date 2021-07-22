package com.bi.wordcounter.domain;

public class Ranking {
	private String word;
	private Long ocurrences;

	public Ranking() {
	}

	public Ranking(String word, Long ocurrences) {
		this.word = word;
		this.ocurrences = ocurrences;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getOcurrences() {
		return ocurrences;
	}

	public void setOcurrences(Long ocurrences) {
		this.ocurrences = ocurrences;
	}

}
