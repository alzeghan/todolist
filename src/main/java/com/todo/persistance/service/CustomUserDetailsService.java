package com.todo.persistance.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.persistance.model.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		try{
			Users user = userService.getValidUserByUsername(username);
			System.out.println("User : "+user);
			if(user==null){
				System.out.println("User not found");
				throw new UsernameNotFoundException("Username not found");
			}
				return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), 
					 true, true, true, true, getGrantedAuthorities(user));	
		}catch(Exception ex){
			
		}
		
		return null;
	}
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsernameAndpassword(String username, String password)
			throws UsernameNotFoundException {
		Users user;
		try {
			user = userService.getValidUser(username, password);
		
		System.out.println("User : "+user);
		if(user == null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Users user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
