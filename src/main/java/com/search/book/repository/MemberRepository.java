package com.search.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.book.vo.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	public Member findById(String id);
	
	
}
