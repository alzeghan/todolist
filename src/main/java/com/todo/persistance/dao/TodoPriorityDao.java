package com.todo.persistance.dao;

import com.todo.persistance.model.TodoPriority;

public interface TodoPriorityDao extends GenericDao<TodoPriority, Integer> {

	TodoPriority getPriorityById(int priorityId);

}
