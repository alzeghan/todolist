package com.todo.persistance.service;

import java.util.List;

import com.todo.persistance.model.Task;

public interface TaskService {
	
	Task createTask(Task task);
	
	Task updateTask(Task task);
	
	List<Task> getAllTasks();
	
	Task getTaskById(Long id);
	

}
