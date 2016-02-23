package com.todo.persistance.dao;

import java.util.List;

import com.todo.persistance.model.Task;

public interface TaskDao extends GenericDao<Task, Long> {

    public List<Task> getTaskListByTitle(final String title);
}
