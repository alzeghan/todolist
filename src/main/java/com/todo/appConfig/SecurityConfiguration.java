package com.todo.appConfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// @formatter:off
		http.addFilterAfter(new OncePerRequestFilter() {
		@Override
		protected void doFilterInternal(HttpServletRequest request,
		HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
							
			filterChain.doFilter(request, response);
								}
		}, AbstractPreAuthenticatedProcessingFilter.class);
		
	  http.authorizeRequests()
	  	.antMatchers("/", "/index","/static/","/static/**","/login","/register","/register.do").permitAll().anyRequest().authenticated()
	  	.and().formLogin().loginPage("/login")
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().csrf().disable();
	}
}
