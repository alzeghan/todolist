package com.todo.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.TodoPriorityDao;
import com.todo.persistance.model.TaskPriority;
import com.todo.persistance.model.Users;


@Repository
public class TodoPriorityDaoImpl extends AbstractGenericDaoImpl<TaskPriority, Integer> implements TodoPriorityDao {

	private static final Logger logger = LoggerFactory.getLogger(TodoPriorityDaoImpl.class);

	public List<Users> getUserById(int userId) {
		return null;

	}

	public TaskPriority getPriorityById(int priorityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
