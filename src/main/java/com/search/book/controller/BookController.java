package com.search.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.search.book.dto.BookSearchResult;
import com.search.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping(value = "/{target}")
	public ResponseEntity<List<BookSearchResult>> books(Model model, 
			@PathVariable("target") String target){
		return new ResponseEntity<>(
				bookService.selectBookList(target),
				HttpStatus.OK
				);
	}
	
}
