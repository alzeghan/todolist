package com.todo.persistance.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.todo.persistance.dao.UserDao;
import com.todo.persistance.model.Users;
import com.todo.persistance.service.UserService;

@Component("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao()
	{
		return this.userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException
	{
		return userDao.isValidUser(username, password);
	}
	
	@Override
	public Users getValidUser(String username, String password) throws SQLException
	{
		return userDao.getUserByUsernamePassword(username, password);
	}
	
	@Override
	public Users getValidUserByUsername(String username) throws SQLException
	{
		return userDao.getUserByUsername(username);
	}
	
}
