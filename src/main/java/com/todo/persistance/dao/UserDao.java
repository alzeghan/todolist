package com.todo.persistance.dao;

import com.todo.persistance.model.Users;

public interface UserDao extends GenericDao<Users, Integer> {

	public Users getUserById(Integer userId);
}
