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
import com.em.login.models.Book;
import com.em.login.models.LoginUser;
import com.em.login.models.User;
import com.em.login.services.BookService;
import com.em.login.services.UserService;

@Controller
public class MainController {
 
	@Autowired
	 private UserService userServ;
	@Autowired
	private BookService bookServ;
//------------------------------------LOGIN & REGISTRAION CONTROLLER--------------------------------------------------

//	---------------LOGIN PAGE----------
	 @GetMapping("/")
	 public String index(Model model) {
		 
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
	     
		 userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "Login.jsp";
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
	         return "Login.jsp";
	     }
	     //If no errors-Store ID in session-->login on
	     session.setAttribute("userId", user.getId());
	     return "redirect:/welcome";
	 }
//----------DASHBOARD -------
	 @GetMapping("/welcome")
	 public String welcome(Model model, HttpSession session) {
	    	
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/";
	    	}
		 model.addAttribute("books", bookServ.all());
		 model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
		 return "dashboard.jsp";		 
	 }
//-------------Logout-----
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	 }

//------------------------------------BOOK CONTROLLER--------------------------------------------------
	 
//-------Adding a Book -----
	 @GetMapping("/books/new")
	 public String addBookToShelf(@ModelAttribute("book") Book book, Model model, HttpSession session) {
	    	
		 User user = userServ.findById((Long)session.getAttribute("userId"));
		 model.addAttribute("user", user);    	
		 return "newBook.jsp";
	}
	 @PostMapping("/books")
	 public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		 if (result.hasErrors()) {
			 return "newBook.jsp";
	    }
		 	bookServ.create(book);
	    	return "redirect:/welcome";
	 }
//--------VIEWING BOOK and DETAILS -----
	@GetMapping("/books/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		//"userId" is just an insance of HttpSession
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//detail jsp doesn't need to know all the books- pulling ONE book
//		model.addAttribute("books", bookServ.all());
		Book book = bookServ.findById(id);
		model.addAttribute("book", book);
		model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));	   
	    return "bookDetails.jsp";
	    }
//---------------------edit---------------------
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id")Long id, @ModelAttribute("book")Book book, Model model,HttpSession session) {
		model.addAttribute("book", bookServ.findById(id));
		//this line is show user in session on HEADER:
		model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));

		return "editBook.jsp";
	}
	@PostMapping("/books/edit/{id}")
	public String updateBook(@Valid @ModelAttribute("book")Book book,BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("book",book);
			return "editBook.jsp";
		}
		bookServ.updateBook(book);
		return "redirect:/books/{id}";
	}
//---------------DESTROY--------------------------
	@GetMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book = bookServ.findById(id);
		bookServ.delete(book);
		return "redirect:/welcome";
	}
//--------------Borrow--------------------------
	@GetMapping("/books/{id}/borrow")
	public String borrowBook(@PathVariable("id")Long id,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book = bookServ.findById(id);
		book.setBorrower(userServ.findById((Long)session.getAttribute("userId")));
		bookServ.updateBook(book);
		return "redirect:/welcome";
	}
//--------------Returning Book--------------------------
	@GetMapping("/books/{id}/return")
	public String returnBook(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null){
			return "redirect:/";
		}
		Book book = bookServ.findById(id);
		book.setBorrower(null);
		bookServ.updateBook(book);
		return "redirect:/welcome";
	}



	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
}

