package com.search.book.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KakaoBookSearchResult implements Serializable, BookSearchResult {
	
	private static final long serialVersionUID = -4496540216537599075L;
	
	private String title;

	private String url;

	private String thumbnail;

	private String[] authors;
	
	private String contents;
	
	private LocalDateTime datetime;
	
	private String isbn;
	
	private BigDecimal price;
	
	private String publisher;
	
	private BigDecimal sale_price;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getThumbnail() {
		return thumbnail;
	}

	@Override
	public String getAuthors() {
		return String.join(",", authors);
	}

	@Override
	public String getContents() {
		return contents;
	}

	@Override
	public String getDateTime() {
		return datetime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
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
		return sale_price;
	}
}
