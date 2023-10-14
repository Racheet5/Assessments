package com.example.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookapp.model.Book;
import com.example.bookapp.repository.BookRepository;

@Service
public class BookServiceInt implements BookService{

	@Autowired
	private BookRepository bookRepo;
	
	public Book addBook(Book book) {
		Book book1 = bookRepo.save(book);
		return book1;
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	



}
