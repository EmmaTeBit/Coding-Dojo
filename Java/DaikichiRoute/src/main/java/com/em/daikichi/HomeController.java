package com.em.daikichi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class HomeController {
	
	@RequestMapping("")
	public String home() {
		return "Welcome!";
	}
	@RequestMapping("/today") 
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomarrow")
	public String tomarrow() {
		return "Tomarrow, an opportunity will arise, so be sure to be open to new ideas!";
		
	}
	@RequestMapping("/travel/{location}")
	public String travel(@PathVariable String location ) {
		return "Congratulations! You are going to " + location ;
		
	}
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable int num) {
		//even Number :
		if (num % 2 == 0 ) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
			
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
