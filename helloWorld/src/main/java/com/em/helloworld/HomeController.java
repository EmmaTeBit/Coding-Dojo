package com.em.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//designator annotation:
@RestController
@RequestMapping("/hello")
public class HomeController {
	@GetMapping("")
	public String index() {
		return "demo.jsp";
	}
	@GetMapping("/bear")
	public String bear() {
		return "Hello Dairy Bear!";
		
	}
}
