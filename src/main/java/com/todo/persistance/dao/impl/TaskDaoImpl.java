package com.todo.persistance.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.TaskDao;
import com.todo.persistance.model.Task;

@Repository
public class TaskDaoImpl extends AbstractGenericDaoImpl<Task, Long>
		implements TaskDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TaskDaoImpl.class);

}
