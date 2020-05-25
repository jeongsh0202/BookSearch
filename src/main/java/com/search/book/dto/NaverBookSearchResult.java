package com.search.book.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class NaverBookSearchResult implements Serializable, BookSearchResult {

	private static final long serialVersionUID = -8911154382061444150L;

	private String title;
	
	private String link;
	
	private String image;
	
	private String author;
	
	private String description;

	private String isbn;

	private BigDecimal price;
	
	private String publisher;

	private BigDecimal discount;
	
	private String pubdate;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getUrl() {
		return link;
	}

	@Override
	public String getThumbnail() {
		return image;
	}

	@Override
	public String getAuthors() {
		return author;
	}

	@Override
	public String getContents() {
		return description;
	}

	@Override
	public String getDateTime() {
		return pubdate;
	}

	@Override
	public String getIsbn() {
		return isbn;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String getPublisher() {
		return publisher;
	}

	@Override
	public BigDecimal getSalePrice() {
		return discount;
	}
}