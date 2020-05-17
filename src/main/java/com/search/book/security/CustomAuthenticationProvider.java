package com.search.book.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.search.book.vo.User;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService customUserDetailsService;
	
	private final PasswordEncoder passwordEncoder;
	
	public CustomAuthenticationProvider(UserDetailsService customUserDetailService, PasswordEncoder passwordEncoder) {
		this.customUserDetailsService = customUserDetailService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		User user = (User) customUserDetailsService.loadUserByUsername(username);
		
		if (!matchPassword(password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
 
        if (!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}
	
	private boolean matchPassword(String loginPassword, String password) {
		return passwordEncoder.matches(loginPassword, password);
    }

}
