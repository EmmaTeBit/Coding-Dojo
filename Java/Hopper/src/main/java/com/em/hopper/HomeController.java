package com.em.hopper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
    	String firstName = "Grace";
    	String lastName = "Hopper";
    	String item = "Copper wire";
    	Double price = 5.25;
    	String description = "Metal Strips. Also an illustration of nanoseconds";
    	String vendor = "Little Things Corner Store";
    	
    	model.addAttribute("first", firstName);
    	model.addAttribute("last", lastName);
    	model.addAttribute("item", item);
    	model.addAttribute("price", price);
    	model.addAttribute("description", description);
    	model.addAttribute("vendor", vendor);

       return "index.jsp";
    }
}

