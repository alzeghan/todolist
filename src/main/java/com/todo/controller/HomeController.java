package com.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView apiDocumentation(ModelMap model) {

		System.out.println("***************** HOME CONTROLLER *********************");
		String message = "test message";
		return new ModelAndView("index", "message", message);

	}

}
