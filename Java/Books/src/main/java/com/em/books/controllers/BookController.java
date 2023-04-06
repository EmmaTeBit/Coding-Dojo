package com.em.books.controllers;

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

import com.em.books.models.Book;
import com.em.books.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	@GetMapping("/books")
	public String index(Model model) {
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";	
	}
//	pathvariable:{bookId}
	@GetMapping("/books/{id}")
	public String index(Model model, @PathVariable("id")Long id) {
			model.addAttribute("book",bookService.findBook(id));
			return "show.jsp";
	}
	//----------form creating new book---------
	@GetMapping("/books/new")
	public String newBook (@ModelAttribute("book")Book book) {
		return "new.jsp";		
	}
	@PostMapping("/books/create")
	public String create(
			@Valid @ModelAttribute("book")Book book,
			BindingResult result) {
			
		if(result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	//--------------edit-------------------
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(
    		@Valid 
    		@ModelAttribute("book") Book book, 
    		BindingResult result,
    		Model model
    		) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	//-------------Destroy-----------------
    

	
	
	
	
	
	
	
	
	
	
	
	
	
}
