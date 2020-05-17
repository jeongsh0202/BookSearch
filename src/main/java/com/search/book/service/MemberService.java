package com.search.book.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.search.book.dto.MemberReq;
import com.search.book.repository.MemberRepository;
import com.search.book.vo.Member;
import com.search.book.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;
	
	public void insertMember(MemberReq memberReq) {
		Member member = new Member();
		member.setId(memberReq.getId());
		member.setPassword(passwordEncoder.encode(memberReq.getPassword()));
		
		memberRepository.save(member);
	}

	public User selectMember(String username) {
		Member member = memberRepository.findById(username);

		return User.builder().id(member.getId())
				.password(member.getPassword())
				.enabled(true)
				.build();
	}
}
