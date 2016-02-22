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
import com.todo.persistance.model.Users;
import com.todo.persistance.modelDTO.BuildingDTO;
import com.todo.persistance.modelDTO.WebModelUtil;
import com.todo.persistance.service.BuildingService;
import com.todo.persistance.service.UserService;

@Controller
@RequestMapping("/building")
public class BuildingController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDoa;

	@Autowired
	private MessageSource messageProvider;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView BuildingHome(Locale locale, Model model) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		List<Building> buildingFromDb = buildingService.getAllBuilding();
		List<BuildingDTO> buildingList = new ArrayList<BuildingDTO>();
		for (Building building : buildingFromDb) {
			buildingList.add(WebModelUtil.createBuildingDTO(building));
		}
		modelAndView.setViewName("building/list");
		modelAndView.addObject("buildingList", buildingList);
		return modelAndView;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createBuildingView(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ModelAndView modelview = new ModelAndView("building/create");
		modelview.addObject("registerTabStyle", "active");
		BuildingDTO building=new  BuildingDTO();
		building.setActive(true);
		modelview.addObject("building", building);

		return modelview;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public ModelAndView createBuilding(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("building") @Valid BuildingDTO requestModel) {
		ModelAndView model = new ModelAndView();
		try {
			Building building = new Building();
			building.setName(requestModel.getName());
			building.setLocation(requestModel.getLocation());
			building.setActive(requestModel.getActive());

			buildingService.createBuilding(building);

			System.out.println("creaed " + building.getName());
		} catch (Exception e) {

		}

		model = new ModelAndView("redirect:/building/list");
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateBuildingView(Model model, @RequestParam(required = true, value = "id") Long id) throws Exception {
		System.out.println("update the value" + id);
		ModelAndView modelview = new ModelAndView("building/edit");
		modelview.addObject("registerTabStyle", "active");
		Building building = buildingService.getBuildingById(id);

		modelview.addObject("building",
				WebModelUtil.createBuildingDTO(building));

		return modelview;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateBuilding(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("building") @Valid BuildingDTO requestModel) {
		ModelAndView model = new ModelAndView();
		try {
			Building building =buildingService.getBuildingById(requestModel.getId());
			
			building.setName(requestModel.getName());
			building.setLocation(requestModel.getLocation());
			building.setActive(requestModel.getActive());

			buildingService.updateBuilding(building);

			System.out.println("updated " + building.getName());
		} catch (Exception e) {

		}

		model = new ModelAndView("redirect:/building/list");
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
