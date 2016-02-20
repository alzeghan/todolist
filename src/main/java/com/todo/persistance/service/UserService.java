package com.todo.persistance.service;

import java.sql.SQLException;

import com.todo.persistance.model.Users;

public interface UserService {

	public boolean isValidUser(String username, String password) throws SQLException;
	public Users getValidUser(String username, String password) throws SQLException;
	public Users getValidUserByUsername(String username) throws SQLException;
}
