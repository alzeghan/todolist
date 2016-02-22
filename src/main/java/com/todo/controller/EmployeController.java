package com.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.persistance.dao.UserDao;
import com.todo.persistance.model.Building;
import com.todo.persistance.model.Employee;
import com.todo.persistance.model.Users;
import com.todo.persistance.modelDTO.BuildingDTO;
import com.todo.persistance.modelDTO.EmployeeDTO;
import com.todo.persistance.modelDTO.WebModelUtil;
import com.todo.persistance.service.BuildingService;
import com.todo.persistance.service.EmployeeService;
import com.todo.persistance.service.UserService;

@Controller
@RequestMapping("/employee")
public class EmployeController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDoa;

	@Autowired
	private MessageSource messageProvider;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String BuildingHome(Locale locale, Model model) throws Exception {

		List<Employee> employeeList = employeeService.getAllEmployee();
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		for (Employee emp : employeeList) {
			empList.add(WebModelUtil.createEmployeeDTO(emp));
		}

		model.addAttribute("empList", empList);
		return "employee/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createBuildingView(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		ModelAndView modelview = new ModelAndView("employee/create");
		EmployeeDTO emp = new EmployeeDTO();
		emp.setActive(true);
		modelview.addObject("emp", emp);

		return modelview;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public ModelAndView createBuilding(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("emp") @Valid EmployeeDTO requestModel){
		ModelAndView model = new ModelAndView();
		try {
			Employee emp = new Employee();
			emp.setName(requestModel.getName());
			emp.setSalary(requestModel.getSalary());
			emp.setTitle(requestModel.getTitle());
			emp.setMaritalStatus(requestModel.getMaritalStatus());
			emp.setActive(requestModel.getActive());

			employeeService.createEmployee(emp);

			System.out.println("creaed " + emp.getName());
		} catch (Exception ex) {
			System.out.println("ERROR adding employee: " + ex.getMessage());
		}

		model = new ModelAndView("redirect:/employee/list");
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateBuildingView(Model model,
			@RequestParam(required = true, value = "id") Long id)
			throws Exception {
		System.out.println("update the value" + id);
		ModelAndView modelview = new ModelAndView("employee/edit");
		modelview.addObject("registerTabStyle", "active");
		Employee emp = employeeService.getEmployeeById(id);

		modelview.addObject("emp", WebModelUtil.createEmployeeDTO(emp));

		return modelview;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateBuilding(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("emp") @Valid EmployeeDTO requestModel) {
		ModelAndView model = new ModelAndView();
		try {
			Employee employe = employeeService.getEmployeeById(requestModel
					.getId());

			employe.setName(requestModel.getName());
			employe.setMaritalStatus(requestModel.getMaritalStatus());
			employe.setSalary(requestModel.getSalary());
			employe.setTitle(requestModel.getTitle());
			employe.setActive(requestModel.getActive());

			employeeService.updateEmployee(employe);

			System.out.println("updated " + employe.getName());
		} catch (Exception e) {

		}

		model = new ModelAndView("redirect:/employee/list");
		return model;
	}

	public void authenticateUser(Users user) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user
				.getUsername());
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(user.getUsername(),
						user.getPassword(), userDetails.getAuthorities()));
	}

}
