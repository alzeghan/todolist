package com.todo.persistance.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.BuildingDao;
import com.todo.persistance.model.Building;
import com.todo.persistance.model.Users;

@Repository
public class BuildingDaoImpl extends AbstractGenericDaoImpl<Building, Long>
		implements BuildingDao {

	private static final Logger logger = LoggerFactory
			.getLogger(BuildingDaoImpl.class);

}
