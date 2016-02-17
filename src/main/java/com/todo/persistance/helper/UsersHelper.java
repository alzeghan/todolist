package com.todo.persistance.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.todo.persistance.dao.UserDao;

@Component("UsersHelper")
@Transactional
public class UsersHelper {

	@Autowired
	private UserDao usersDoa;
	
}
