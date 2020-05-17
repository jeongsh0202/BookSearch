package com.search.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.search.book.dto.MemberReq;
import com.search.book.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping
	public String insert(MemberReq memberReq) {
		memberService.insertMember(memberReq);
		
		return "redirect:/login";	
	}
}
