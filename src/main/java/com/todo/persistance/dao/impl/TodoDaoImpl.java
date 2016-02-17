package com.todo.persistance.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.TodoDao;
import com.todo.persistance.model.Todo;
import com.todo.persistance.model.Users;


@Repository
public class TodoDaoImpl extends AbstractGenericDaoImpl<Todo, Integer> implements TodoDao {

	private static final Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);

	public List<Users> getUserById(int userId) {
		try {
//			Criteria criteria = getSession().createCriteria(HubRoute.class);
//			criteria.createAlias("hubFrom", "hubFrom");
//			criteria.createAlias("hubFrom.country", "country");
//			criteria.add(Restrictions.eq("country.code", countryCode));
//			@SuppressWarnings("unchecked")
//			List<HubRoute> list = criteria.list();
//
//			return list;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;

	}
	
	public Todo getTodoById(int todoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
