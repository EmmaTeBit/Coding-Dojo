package com.em.travel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.em.travel.models.Travel;
import com.em.travel.services.TravelService;

@Controller
public class TravelController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("travel")Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
//		for(Travel e: travels) {
////			System.out.println(e.getAmount()); 
//		}
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	@PostMapping("/createTravel")
	public String create(@Valid @ModelAttribute("travel")Travel travel,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travel> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		} 
		travelService.createTravel(travel);
		return "redirect:/";
	}
	//---------------------Show Detail--------------------

//	pathvariable:{Id}
	@GetMapping("/travels/{id}")
	public String index(Model model, @PathVariable("id")Long id) {
			model.addAttribute("travel",travelService.findTravel(id));
			return "showdetail.jsp";
	}
	//---------------------edit---------------------
	@GetMapping("/edit/{id}")
	public String editTravel(@PathVariable("id") Long id, @ModelAttribute("burger") Travel burger, Model model) {
		model.addAttribute("travel", travelService.findTravel(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String updateTravel(@Valid @ModelAttribute("burger") Travel travel, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travel", travel);
			return "index.jsp";
		}
		travelService.updateTravel(travel);
		return "redirect:/";
	}
	//---------------DESTROY--------------------------
	 @RequestMapping(value="/travels/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        travelService.deleteTravel(id);
	        return "redirect:/";
	    }


}
