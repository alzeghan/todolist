package com.todo.persistance.service.impl;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionAdvice {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {

		ModelAndView mav = new ModelAndView("errorPage");
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());

		return mav;
	}
}
