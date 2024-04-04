package com.app.raghu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//for authorization
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/","/login").permitAll()
		.anyRequest().authenticated()
		.and().oauth2Login();
		
		return http.build();
	}
}
