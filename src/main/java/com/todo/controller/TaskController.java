package com.todo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.persistance.model.Employee;
import com.todo.persistance.model.Task;
import com.todo.persistance.model.TaskPriority;
import com.todo.persistance.modelDTO.TaskDTO;
import com.todo.persistance.modelDTO.WebModelUtil;
import com.todo.persistance.service.EmployeeService;
import com.todo.persistance.service.TaskService;
import com.todo.persistance.service.UserService;
import com.todo.util.TodoListUtils;
import com.todo.util.TodoPriorityPropertyEditor;

@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MessageSource messageProvider;

	@Autowired
	private TaskService taskService;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TodoListUtils.DATE_FORMAT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//        binder.registerCustomEditor(TaskPriority.class, new TodoPriorityPropertyEditor());
    }
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView TasksHome(Locale locale, Model model) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		List<Task> taskFromDb = taskService.getAllTasks();
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		for (Task task : taskFromDb) {
//			System.out.println(task.getDescription());
//			System.out.println(task.getEmployee().toString());
			taskList.add(WebModelUtil.createTaskDTO(task));
		}
		
		int totalCount = taskList.size();
        int doneCount = TodoListUtils.countTotalDone(taskList);
        int todoCount = totalCount - doneCount;
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("doneCount", doneCount);
        modelAndView.addObject("todoCount", todoCount);
        modelAndView.addObject("homeTabStyle", "active");
        
        
		modelAndView.setViewName("task/list");
		modelAndView.addObject("taskList", taskList);
		return modelAndView;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createTaskView(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		ModelAndView modelview = new ModelAndView("task/create");
		
		TaskDTO task = new TaskDTO();
		task.setActive(true);
		
		List<Employee> allEmployees = employeeService.getAllEmployee();
		model.addAttribute("today", new SimpleDateFormat(TodoListUtils.DATE_FORMAT).format(new Date()));
		modelview.addObject("allEmployees",allEmployees);
		modelview.addObject("task", task);

		return modelview;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public ModelAndView createTask(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("task") @Valid TaskDTO requestModel) {
		
		ModelAndView model = new ModelAndView();
		try {
			Employee emp = employeeService.getEmployeeById(requestModel.getAssignedTo().getId());
			
			Task task = new Task();
			
			task.setEmployee(emp);
			task.setDescription(requestModel.getDescription());
//			task.setDueDate(requestModel.getDueDate());
//			task.setStartDate(requestModel.getStartDate());
			task.setDueDate(new Date());
			task.setStartDate(new Date());
			task.setStatus(false);
			task.setActive(requestModel.isActive());
			task.setPriority(requestModel.getPriority());
			
			taskService.createTask(task);

			System.out.println("created " + task.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}

		model = new ModelAndView("redirect:/task/list");
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateTaskView(Model model, @RequestParam(required = true, value = "id") Long id){
		
		System.out.println("update the value" + id);
		
		ModelAndView modelview = new ModelAndView("task/edit");
		Task task = taskService.getTaskById(id);
		List<Employee> allEmployees = employeeService.getAllEmployee();
		modelview.addObject("allEmployees",allEmployees);
		modelview.addObject("task",WebModelUtil.createTaskDTO(task));

		return modelview;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateTask(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("task") @Valid TaskDTO requestModel) {
		System.out.println("in update =========");
		
		ModelAndView model = new ModelAndView();
		try {
			
			System.out.println("requestModel.getDescription(): "+requestModel.toString());
			Employee emp = employeeService.getEmployeeById(requestModel.getAssignedTo().getId());
			
			Task task = taskService.getTaskById(requestModel.getId());
			
			task.setEmployee(emp);
			task.setDescription(requestModel.getDescription());
			task.setDueDate(requestModel.getDueDate());
			task.setStartDate(requestModel.getStartDate());
			task.setStatus(requestModel.isStatus());
			task.setActive(requestModel.isActive());
			task.setPriority(requestModel.getPriority());

			taskService.updateTask(task);

			System.out.println("updated " + task.getDescription());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		model = new ModelAndView("redirect:/task/list");
		return model;
	}



  @RequestMapping(value = "/{taskId}/delete", method = RequestMethod.POST)
  public ModelAndView deleteTodo(@PathVariable long taskId) {
      ModelAndView modelAndView = new ModelAndView();
      Task task = taskService.getTaskById(taskId);
      if (task == null) {
          modelAndView.addObject("error", messageProvider.getMessage("no.such.todo", new Object[]{taskId}, Locale.ENGLISH));
          modelAndView.setViewName("error");
      } else {
          taskService.removeTask(task);
          modelAndView.setViewName("redirect:/task/list");
      }
      return modelAndView;
  }

}
