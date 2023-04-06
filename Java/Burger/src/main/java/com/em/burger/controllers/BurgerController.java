package com.em.burger.controllers;

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

import com.em.burger.models.Burger;
import com.em.burger.services.BurgerService;

@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String home(@ModelAttribute("burger")Burger buger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	@PostMapping("/createBurger")
	public String create(@Valid @ModelAttribute("burger")Burger buger,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		} 
		burgerService.createBurger(buger);
		return "redirect:/";
	}
	//---------------------edit---------------------
	@GetMapping("/edit/{id}")
	public String editBurger(@PathVariable("id") Long id, @ModelAttribute("burger") Burger burger, Model model) {
		model.addAttribute("burger", burgerService.findBurger(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "index.jsp";
		}
		burgerService.updateBurger(burger);
		return "redirect:/";
	}
	//---------------DESTROY--------------------------
	 @RequestMapping(value="/burgers/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        burgerService.deleteBurger(id);
	        return "redirect:/";
	    }
	 //or:
//	 @DeleteMapping("/books/{id}")
//	    public String destroy(@PathVariable("id") Long id) {
//	        bookService.deleteBook(id);
//	        return "redirect:/books";
//	    }

}
