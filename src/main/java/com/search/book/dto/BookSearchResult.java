package com.search.book.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookSearchResult implements Serializable {
	
	private static final long serialVersionUID = -4496540216537599075L;
	
	private String[] authors;
	
	private String contents;
	
	private LocalDateTime datetime;
	
	private String isbn;
	
	private BigDecimal price;
	
	private String publisher;
	
	private BigDecimal sale_price;

	private String status;
	
	private String thumbnail;
	
	private String title;
	
	private String[] translators;
	
	private String url;
	
	
	
}
