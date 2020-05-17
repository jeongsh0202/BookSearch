package com.search.book.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import com.search.book.security.CustomAuthenticationProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	private final UserDetailsService customUserDetailService;
	
	private final PasswordEncoder passwordEncoder;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/login", "/test_db/**", "/members")
            .permitAll()
        .and()
            .formLogin()
            .loginPage("/login-action")
            .failureUrl("/login?error=true")
            .defaultSuccessUrl("/main")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
        .and()
            .csrf()
            .disable()
        .headers()
            .addHeaderWriter(
                new XFrameOptionsHeaderWriter(
                    new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))    // 여기!
                )
            )
            .frameOptions().sameOrigin();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }
    
    @Bean
    public AuthenticationProvider athenticationProvider() {
    	return new CustomAuthenticationProvider(customUserDetailService, passwordEncoder);
    }
}
