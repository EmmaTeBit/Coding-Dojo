package com.em.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.login.models.Book;
import com.em.login.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	//find by ID
	public Book findById(Long id) {
		Optional<Book> result = bookRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	//findall
	public List<Book> all() {
		return bookRepo.findAll();
	}
	//create
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	//update 
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	//delete
	public void delete(Book book) {
		bookRepo.delete(book);
		}
	
}
