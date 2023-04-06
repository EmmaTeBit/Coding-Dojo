package com.em.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.em.login.models.LoginUser;
import com.em.login.models.Project;
import com.em.login.models.Task;
import com.em.login.models.User;
import com.em.login.services.ProjectService;
import com.em.login.services.TaskService;
import com.em.login.services.UserService;

@Controller
public class MainController {
 
	@Autowired
	 private UserService UserService;
	@Autowired
	private ProjectService ProjectService;
	@Autowired
	private TaskService TaskService;
	
	
//------------------------------------LOGIN & REGISTRAION CONTROLLER--------------------------------------------------

//	---------------LOGIN PAGE----------
	 @GetMapping("/")
	 public String login(Model model) {
		 
		 //Bind empty User & LoginUser object to JSP and capture the form input
		 //REMINDER: model name must match JSP modelAttribute
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "Login.jsp";
	 }
//	---------REGISTRATION----------
	 @PostMapping("/register")
	 public String register(@Valid  @ModelAttribute("newUser") User newUser, BindingResult result, 
	         Model model, HttpSession session) {
	     
		 UserService.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "Login.jsp";
	     }	  
	     session.setAttribute("userId", newUser.getId());
	     return "redirect:/dashboard";
	 }
//	------------LOGIN & Confirmation----
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     User user = UserService.login(newLogin, result);
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "Login.jsp";
	     }
	     //If no errors-Store ID in session-->login on
	     session.setAttribute("userId", user.getId());
	     return "redirect:/dashboard";
	 }
	//-------------Logout-----
		 @GetMapping("/logout")
		 public String logout(HttpSession session) {
			 session.setAttribute("userId", null);
			 return "redirect:/";
		 }

//------------------------------------DASHBOARD------------------------------------------------------
	 @GetMapping("/dashboard")
	 public String dashboard(Model model, HttpSession session) {
	    	
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
	    	}
		 model.addAttribute("projects", ProjectService.all());
		 model.addAttribute("user", UserService.findById((Long)session.getAttribute("userId")));
		 return "dashboard.jsp";		 
	 }
//------------------------------------NEW PROEJCT---------------------------------------------
	 @GetMapping("/projects/new")
	 public String addProject(@ModelAttribute("project") Project project, Model model, HttpSession session) {
	    	
		 User user = UserService.findById((Long)session.getAttribute("userId"));
		 model.addAttribute("user", user);    	
		 return "newProject.jsp";
	}
	 @PostMapping("/projects")
	 public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {

		 if (result.hasErrors()) {
			 return "newProject.jsp";
	    }
		 ProjectService.createProject(project);
	    	return "redirect:/dashboard";
	 }
//--------VIEWING and DETAILS -----
	@GetMapping("/projects/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		//"userId" is just an insance of HttpSession
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//detail jsp doesn't need to know all the Projects- pulling ONE Project
		Project project = ProjectService.findById(id);
		model.addAttribute("project", project);
		model.addAttribute("user", UserService.findById((Long)session.getAttribute("userId")));	   
	    return "projectDetails.jsp";
	    }
//---------------------edit---------------------
	@GetMapping("/projects/edit/{id}")
	public String edit(@PathVariable("id")Long id, @ModelAttribute("project")Project project, Model model,HttpSession session) {
		model.addAttribute("project", ProjectService.findById(id));
		//this line is show user in session on HEADER:
		model.addAttribute("user", UserService.findById((Long)session.getAttribute("userId")));

		return "editProject.jsp";
	}
	@PostMapping("/projects/edit/{id}")
	public String update(@Valid @ModelAttribute("project")Project project,BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("project",project);
			return "editProject.jsp";
		}
		ProjectService.updateProject(project);
		return "redirect:/projects/{id}";
	}
//---------------DESTROY--------------------------
	@GetMapping("/projects/delete/{id}")
	public String delete(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Project project = ProjectService.findById(id);
		ProjectService.deleteProject(project);
		return "redirect:/dashboard";
	}
//--------------JOIN TEAM-------------------------
	@GetMapping("/projects/{id}/joinTeam")
	public String joinTeam(@PathVariable("id")Long id,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Project project = ProjectService.findById(id);
		project.setTeam(UserService.findById((Long)session.getAttribute("userId")));
		ProjectService.updateProject(project);
		return "redirect:/dashboard";
	}
//--------------LEAVING Project--------------------------
	@GetMapping("/projects/{id}/leave")
	public String leaveTeam(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null){
			return "redirect:/";
		}
		Project project = ProjectService.findById(id);
		project.setTeam(null);
		ProjectService.updateProject(project);
		return "redirect:/dashboard";
	}
//-------------TASK--------------------------
	@GetMapping("/projects/{id}/tasks")
	public String task(Model model, @PathVariable("id") Long id, HttpSession session,
			@ModelAttribute("project")Project project,
			@ModelAttribute("task")Task task) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//task jsp doesn't need to know all the Projects- pulling ONE Project
		Task taskId = TaskService.findById(id);
		//this line is show user in session on HEADER:
		model.addAttribute("user", UserService.findById((Long)session.getAttribute("userId")));	   
		model.addAttribute("task", taskId);
		model.addAttribute("project", ProjectService.findById(id));
		return "projectTask.jsp";
	    }
	@PostMapping("/tasks")
	public String addTask(@Valid @ModelAttribute("task")Task task,BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("task",task);
			return "projectTask.jsp";
		}
		TaskService.createTask(task);
		return "redirect:/projects/{id}";
	}

	//---------------------edit---------------------
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
}

