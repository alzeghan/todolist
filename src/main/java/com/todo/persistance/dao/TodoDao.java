package com.todo.persistance.dao;

import com.todo.persistance.model.Task;

public interface TodoDao extends GenericDao<Task, Integer> {

	Task getTodoById(int todoId);

}
