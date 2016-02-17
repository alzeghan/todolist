package com.todo.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.TodoPriorityDao;
import com.todo.persistance.model.TodoPriority;
import com.todo.persistance.model.Users;


@Repository
public class TodoPriorityDaoImpl extends AbstractGenericDaoImpl<TodoPriority, Integer> implements TodoPriorityDao {

	private static final Logger logger = LoggerFactory.getLogger(TodoPriorityDaoImpl.class);

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

	public TodoPriority getPriorityById(int priorityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
