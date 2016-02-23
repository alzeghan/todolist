package com.todo.persistance.modelDTO;

import com.todo.persistance.model.Building;
import com.todo.persistance.model.Employee;
import com.todo.persistance.model.Task;


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

	public static TaskDTO createTaskDTO(Task task) {

		TaskDTO taskDto=new TaskDTO();
		taskDto.setId(task.getId());
		taskDto.setAssignedTo(task.getEmployee());
		taskDto.setDescription(task.getDescription());
		taskDto.setDueDate(task.getDueDate());
		taskDto.setStartDate(task.getStartDate());
		taskDto.setStatus(task.isStatus());
		taskDto.setActive(task.isActive());
		taskDto.setPriority(task.getPriority());
		return taskDto;
	}
	

}
