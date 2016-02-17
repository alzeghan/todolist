package com.todo.persistance.dao;

import com.todo.persistance.model.Todo;

public interface TodoDao extends GenericDao<Todo, Integer> {

	Todo getTodoById(int todoId);

}
