package com.todo.persistance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.persistance.dao.BuildingDao;
import com.todo.persistance.model.Building;
import com.todo.persistance.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDao buildingDao;

	@Override
	public Building createBuilding(Building building) {
		buildingDao.save(building);

		return building;
	}

	@Override
	public List<Building> getAllBuilding() {
		return buildingDao.findAll();
	}

	@Override
	public Building getBuildingById(Long id) {
		return buildingDao.findByPrimaryKey(id);
	}

	@Override
	public Building updateBuilding(Building building) {
		return buildingDao.update(building);
	}
}
