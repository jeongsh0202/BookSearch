package com.search.book.dto;

import java.math.BigDecimal;

public interface BookSearchResult {
	
	public abstract String getTitle();
	
	public abstract String getUrl();
	
	public abstract String getThumbnail();

	public abstract String getAuthors();
	
	public abstract String getContents();
	
	public abstract String getDateTime();
	
	public abstract String getIsbn();
	
	public abstract BigDecimal getPrice();
	
	public abstract String getPublisher();
	
	public abstract BigDecimal getSalePrice();
	
}
