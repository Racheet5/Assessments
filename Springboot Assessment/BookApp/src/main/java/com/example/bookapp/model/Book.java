package com.example.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@Column(length = 20)
	private String bookId;
	@Column(length = 100)
	private String booktitle;
	@Column(length = 50)
	private String author;
	@Column(length = 20)
	private String price;

	
	public Book() {
		super();
	}

	public Book(String bookId, String booktitle, String author, String price) {
		super();
		this.bookId = bookId;
		this.booktitle = booktitle;
		this.author = author;
		this.price = price;
	
	}
	
	
	


	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", booktitle=" + booktitle + ", author=" + author + ", price=" + price
				+  "]";
	}

	
	
	
	
}
