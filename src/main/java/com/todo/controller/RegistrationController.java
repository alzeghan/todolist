
package com.todo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.persistance.dao.UserDao;
import com.todo.persistance.model.Users;
import com.todo.persistance.modelDTO.ChangePasswordDTO;
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
			
			
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			auth.setAuthenticated(true);
			 request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		        
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
	
	 @RequestMapping("/account")
	    public ModelAndView redirectToAccountPage() {
	        ModelAndView modelAndView = new ModelAndView("user/account");
	        try{
	        	System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	        	final User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        Users users = userService.getValidUserByUsername(user.getUsername());
		        System.out.println(users.getFirstName());
		        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
		        modelAndView.addObject("user", users);
		        modelAndView.addObject("changePasswordDTO", changePasswordDTO);
	        }catch(Exception ex){
	        	System.out.println("ERROR:1 " + ex.getMessage());
	        	modelAndView.setViewName("user/login");
        		return modelAndView;
	        }
	        
	        
	        
	        return modelAndView;
	    }

	 @RequestMapping(value = "/account/update.do", method = RequestMethod.POST)
	    public String updatePersonalInformation(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, Model model) {
	        
		 	final User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 	Users users = new Users();
	        try{
	        	
		        users = userService.getValidUserByUsername(user.getUsername());
	        }catch(Exception ex){
	        	System.out.println("ERROR:2 " + ex.getMessage());
	        }
	        
	        
	        if (userDoa.getUserByUsername(username) == null) {
	            model.addAttribute("error", messageProvider.getMessage("account.email.alreadyUsed", new Object[]{username}, Locale.ENGLISH));
	        } else {
	            users.setFirstName(firstName);
	            users.setLastName(lastName);
	            users.setUsername(username);
	            userDoa.update(users);
	            model.addAttribute("updateProfileSuccessMessage", messageProvider.getMessage("account.profile.update.success", null, Locale.ENGLISH));
	            model.addAttribute("changePasswordDTO", new ChangePasswordDTO()); //needed since the update password form is on the same page
	        }
	        model.addAttribute("user", users);
	        return "user/account";
	    }
	 
	    @RequestMapping(value = "/account/delete.do", method = RequestMethod.POST)
	    public String deleteAccount(HttpServletRequest request, HttpServletResponse response) {
	    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	
	    	 try{
			        Users users = userService.getValidUserByUsername(user.getUsername());
			        userDoa.delete(Integer.parseInt(String.valueOf(users.getId())));     
		        }catch(Exception ex){
		        	System.out.println("ERROR: " + ex.getMessage());
		        }
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
	        
	        return "index";
	    }

	    @RequestMapping(value = "/user/account/password.do", method = RequestMethod.POST)
	    public String changePassword(@Valid ChangePasswordDTO changePasswordDTO, BindingResult bindingResult, Model model) {
	        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String view = "user/account";
	        Users users = new Users();
	        try{
		        users = userService.getValidUserByUsername(user.getUsername());
		            
	        }catch(Exception ex){
	        	System.out.println("ERROR: " + ex.getMessage());
	        }
	        

	        if (bindingResult.hasErrors()) {
	            model.addAttribute("user", users);
	            return view;
	        }
	        
	        if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmationPassword())) {
	            model.addAttribute("error", messageProvider.getMessage("account.password.confirmation.error", null, Locale.ENGLISH));
	            model.addAttribute("user", users);
	            return view;
	        }
	        
	        if (currentPasswordIsIncorrect(changePasswordDTO, user)) {
	            model.addAttribute("error", messageProvider.getMessage("account.password.error", null,Locale.ENGLISH));
	            model.addAttribute("user", users);
	            return view;
	        }
	        
	        try{
		        users = userService.getValidUserByUsername(user.getUsername());
		        users.setPassword(changePasswordDTO.getNewPassword());
		        userDoa.update(users);     
	        }catch(Exception ex){
	        	System.out.println("ERROR: 3" + ex.getMessage());
	        }
	        
	        
	        model.addAttribute("updatePasswordSuccessMessage", messageProvider.getMessage("account.password.update.success", null, Locale.ENGLISH));
	        model.addAttribute("user", users);
	        return view;

	    }
	    
	    private boolean currentPasswordIsIncorrect(ChangePasswordDTO changePasswordDTO, User user) {
	        return !user.getPassword().equals(changePasswordDTO.getCurrentPassword());
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
