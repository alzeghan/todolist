package com.todo.persistance.dao;

import java.sql.SQLException;

import com.todo.persistance.model.Users;

public interface UserDao extends GenericDao<Users, Integer> {

	public Users getUserById(Integer userId);
	public boolean isValidUser(String username, String password) throws SQLException;
}
