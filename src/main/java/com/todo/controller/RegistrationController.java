
package com.todo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todo.persistance.dao.UserDao;
import com.todo.persistance.model.Users;
import com.todo.persistance.modelDTO.UserDTO;
import com.todo.persistance.service.UserService;


@Controller
public class RegistrationController
{
	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDoa;

	@Autowired
    private MessageSource messageProvider;
		 
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
    
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response,  Model model)
	{
		ModelAndView modelview = new ModelAndView("user/register");
		modelview.addObject("registerTabStyle", "active");
		modelview.addObject("userDTO", new UserDTO());

		return modelview;
	}
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("UserDTO") @Valid UserDTO userDTO)
	{
		ModelAndView model =  new ModelAndView();
		System.out.println(userDTO);
		try{
			System.out.println(userService.getValidUserByUsername(userDTO.getUsername()));
			if((Users)userService.getValidUserByUsername(userDTO.getUsername()) != null){
				model.setViewName("user/register");
				model.addObject("error", "User Already Exist!");
				model.addObject("userDTO", new UserDTO());
				model.addObject("registerTabStyle", "active");
				return model;
			}
			
			if(!userDTO.getPassword().equals(userDTO.getMatchingPassword())){
				model.setViewName("user/register");
				model.addObject("error", "Not matched password!");
				model.addObject("userDTO", new UserDTO());
				model.addObject("registerTabStyle", "active");
				return model;
			}

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		try{
			Users user = new Users();
			user.setFirstName(userDTO.getFirstName());
			user.setLastName(userDTO.getLastName());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			
			userDoa.save(user);
			request.setAttribute("loggedInUser", userDTO.getUsername());
			model = new ModelAndView("index");
			
			try {
					authenticateUser(user);
			    } catch (Exception e) {
			    	System.out.println();
			    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}
	
	 public void authenticateUser(Users user) {
		 UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	        SecurityContextHolder.getContext().setAuthentication(
	                new UsernamePasswordAuthenticationToken(
	                        user.getUsername(),
	                        user.getPassword(),
	                        userDetails.getAuthorities()));
	    }

}
