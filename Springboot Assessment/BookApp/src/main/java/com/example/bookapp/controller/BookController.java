package com.example.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapp.model.Book;
import com.example.bookapp.service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

		@Autowired
		private BookService bookServ;

		

		@PostMapping
		public ResponseEntity<?> addAlbum(@RequestBody Book book) {
			
			System.out.println(book);
			Book book1 = bookServ.addBook(book);
			if( book1 !=null) {
				return new ResponseEntity<Book>(book1,HttpStatus.CREATED);
			}
			
			return new ResponseEntity<String>("Book not added",HttpStatus.CONFLICT);

		}
		
		@GetMapping
		public ResponseEntity<?> getAllBooks() {
			
			List<Book> booklist = bookServ.getAllBooks();
			
			if(booklist.size() > 0) {
				return new ResponseEntity<List<Book>>(booklist,HttpStatus.OK);
			}

			return new ResponseEntity<String>("List is empty",HttpStatus.OK);
			
		}

}

