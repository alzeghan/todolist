package com.todo.persistance.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.TaskDao;
import com.todo.persistance.model.Task;

@Repository
public class TaskDaoImpl extends AbstractGenericDaoImpl<Task, Long> implements TaskDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TaskDaoImpl.class);

	
	public List<Task> getTaskListByTitle(final String title) {
		
		System.out.println(title);
		Query query = getEntityManager().createQuery("from Task t where upper(t.description) like :value order by t.dueDate");
		query.setParameter("value","%" + title.toUpperCase() + "%");
        List<Task> tasklist = query.getResultList();
        
        return tasklist;
    }
}
