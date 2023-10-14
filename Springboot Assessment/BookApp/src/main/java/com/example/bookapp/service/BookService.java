package com.example.bookapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookapp.model.Book;


public interface BookService {

	public Book addBook(Book book);
	public List<Book> getAllBooks();
	
	
	
}
