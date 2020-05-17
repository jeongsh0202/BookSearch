package com.search.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.book.dto.BookSearchResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
	
	public List<BookSearchResult> selectBookList(String target){
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK a1eafe8e98bfbb72bd1f8ea877c95925");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		String uri = "https://dapi.kakao.com/v3/search/book?query=" + target;
        
        ResponseEntity<JsonNode> response = restTemplate .exchange(uri.toString(), HttpMethod.GET, entity, JsonNode.class);
        log.debug("book search response: {}", response);
        
		JsonNode map = response.getBody();
		JsonNode documents = map.get("documents");
		JsonNode totalCount = map.get("meta").get("total_count");

		List<BookSearchResult> searchResultList = new ObjectMapper().convertValue(documents, ArrayList.class);
		
		return searchResultList;
	}
}