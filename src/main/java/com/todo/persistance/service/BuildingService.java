package com.todo.persistance.service;

import java.util.List;

import com.todo.persistance.model.Building;

public interface BuildingService {
	
	Building createBuilding(Building building);
	
	Building updateBuilding(Building building);
	
	List<Building> getAllBuilding();
	
	Building getBuildingById(Long id);
	

}
