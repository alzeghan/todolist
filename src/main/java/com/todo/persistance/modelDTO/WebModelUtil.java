package com.todo.persistance.modelDTO;

import com.todo.persistance.model.Building;
import com.todo.persistance.model.Employee;


public class WebModelUtil {

	public static BuildingDTO createBuildingDTO(Building building) {

		BuildingDTO buildingDto=new BuildingDTO();
		buildingDto.setId(building.getId());
		buildingDto.setName(building.getName());
		buildingDto.setLocation(building.getLocation());
		buildingDto.setActive(building.getActive());
		
		return buildingDto;
	}
	
	public static EmployeeDTO createEmployeeDTO(Employee employeeFromDB) {
		EmployeeDTO employee=new EmployeeDTO();
		employee.setId(employeeFromDB.getId());
		employee.setMaritalStatus(employeeFromDB.getMaritalStatus());
		employee.setName(employeeFromDB.getName());
		employee.setSalary(employeeFromDB.getSalary());
		employee.setTitle(employeeFromDB.getTitle());
		employee.setActive(employeeFromDB.getActive());
		
		return employee;
	}

	

}
