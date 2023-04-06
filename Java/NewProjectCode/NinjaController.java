package com.em.dojo.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.em.dojo.models.Dojo;
import com.em.dojo.models.Ninja;
import com.em.dojo.services.AppService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {

	@Autowired
	private AppService aService;
	
//	-----------------------Rendering JSP and POST-----------------------------------
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model viewModel) {
		List<Dojo> allDojos = this.aService.allDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}
	@PostMapping("/createNinja")
	public String dojoCreate(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.aService.allDojos(); 
			viewModel.addAttribute("allDojos", allDojos);
			return "newNinja.jsp";
		}
		this.aService.createNinja(ninja);
		return "redirect:/dojo/" + ninja.getDojo().getId();
	}
//	--------------------------------------------------------------------------
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
