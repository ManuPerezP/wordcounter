package com.bi.wordcounter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {
	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("total_pages")
	private Integer totalPages;
	@JsonProperty("text")
	private String text;

	public Text(String id, String title, Integer page, Integer totalPages, String text) {
		super();
		this.id = id;
		this.title = title;
		this.page = page;
		this.totalPages = totalPages;
		this.text = text;
	}

	public Text() {
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Text [id=" + id + ", title=" + title + ", page=" + page + ", totalPages=" + totalPages + ", text="
				+ text + "]";
	}

}