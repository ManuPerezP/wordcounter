package com.bi.wordcounter.domain;

import java.io.Serializable;
import java.util.List;

public class CounterResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String fullText;
	private List<Ranking> ranking;

	public CounterResponse(String id, String title, String fullText, List<Ranking> ranking) {
		super();
		this.id = id;
		this.title = title;
		this.fullText = fullText;
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public List<Ranking> getRanking() {
		return ranking;
	}

	public void setRanking(List<Ranking> ranking) {
		this.ranking = ranking;
	}

}
