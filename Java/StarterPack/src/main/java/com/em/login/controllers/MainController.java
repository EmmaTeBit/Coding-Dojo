package com.em.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.em.login.models.LoginUser;
import com.em.login.models.User;
import com.em.login.services.UserService;

@Controller
public class MainController {
 
	@Autowired
	 private UserService userServ;

//------------------------------------LOGIN & REGISTRAION CONTROLLER--------------------------------------------------

//	---------------LOGIN PAGE----------
	 @GetMapping("/")
	 public String index(Model model) {
		 
		 //Bind empty User & LoginUser object to JSP and capture the form input
		 //REMINDER: model name must match JSP modelAttribute
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "login.jsp";
	 }
//	---------REGISTRATION----------
	 @PostMapping("/register")
	 public String register(@Valid  @ModelAttribute("newUser") User newUser, BindingResult result, 
	         Model model, HttpSession session) {
	     
		 userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "login.jsp";
	     }	  
	     session.setAttribute("userId", newUser.getId());
	     return "redirect:/welcome";
	 }
//	------------LOGIN & Confirmation----
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     User user = userServ.login(newLogin, result);
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "login.jsp";
	     }
	     //If no errors-Store ID in session-->login on
	     session.setAttribute("userId", user.getId());
	     return "redirect:/welcome";
	 }
//-------------Logout------------------
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	 }

	//------------------------------------------------------------------------------------




	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
}

