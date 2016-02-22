package com.todo.persistance.dao;

import com.todo.persistance.model.TaskPriority;

public interface TodoPriorityDao extends GenericDao<TaskPriority, Integer> {

	TaskPriority getPriorityById(int priorityId);

}
