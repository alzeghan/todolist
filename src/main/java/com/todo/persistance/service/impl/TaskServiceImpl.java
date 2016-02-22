package com.todo.persistance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.persistance.dao.BuildingDao;
import com.todo.persistance.dao.TaskDao;
import com.todo.persistance.model.Building;
import com.todo.persistance.model.Task;
import com.todo.persistance.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public Task createTask(Task task) {
		taskDao.save(task);

		return task;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskDao.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		return taskDao.findByPrimaryKey(id);
	}

	@Override
	public Task updateTask(Task task) {
		return taskDao.update(task);
	}
}
