package com.search.book;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.search.book.dto.BookSearchResult;
import com.search.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ApplicationTests {

	@Autowired
	private BookService bookService;
	
	@Test
	public void getBookList() {
		String target = "미움받을 용기";
		List<BookSearchResult> selectBookList = bookService.selectKakaoBookList(target);
		
		log.debug("book search result: {}", selectBookList);
	}

}
