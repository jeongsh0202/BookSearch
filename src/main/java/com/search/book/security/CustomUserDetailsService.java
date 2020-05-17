package com.search.book.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.search.book.service.MemberService;
import com.search.book.vo.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberService memberService;
	

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = memberService.selectMember(username);
        
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
