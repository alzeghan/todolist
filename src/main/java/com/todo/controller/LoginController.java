package com.todo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todo.persistance.model.Users;
import com.todo.persistance.service.UserService;


@Controller
@EnableWebMvcSecurity
public class LoginController
{
	@Autowired
	private UserService loginService;

    @Autowired
    private MessageSource messageProvider;
    
	@RequestMapping(value="/loginqwe",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("user/login");
		Users userBean = new Users();
		model.addObject("userBean", userBean);
		return model;
	}
	@RequestMapping(value="/loginqwe",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,Model reqmodel, @ModelAttribute("userBean")Users userBean)
	{
		ModelAndView model= null;
		try
		{
			boolean isValidUser = loginService.isValidUser(userBean.getUsername(), userBean.getPassword());
			System.out.println(isValidUser);
			if(isValidUser){
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", userBean.getUsername());
				model = new ModelAndView("index");
				reqmodel.addAttribute("CurrPrincipal",
				            SecurityContextHolder.getContext()
				                .getAuthentication().getName());
			}else{
				model = new ModelAndView("user/login");
				model.addObject("userBean", userBean);
	            model.addObject("error", messageProvider.getMessage("login.error.global.invalid", null, Locale.ENGLISH));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
