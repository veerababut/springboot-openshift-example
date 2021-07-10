package com.demo.practies.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.practies.model.Book;

@RestController
public class BookStoreController {

	ArrayList<Book> list = new ArrayList<Book>();

	@GetMapping("/")
	public String addBooksMsg() {
		return "Please add any books before to see the data";
	}

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		list.add(book);
		return "Added book wiht id :" + book.getId();
	}

	@PostMapping("/addBooks")
	public String saveBooks(@RequestBody List<Book> books) {
		books.forEach(b -> list.add(b));
		return "Added all books";
	}

	@GetMapping("/findBooks/{id}")
	public Book findByBookId(@PathVariable int id) {
		if (list != null) {
			return list.stream().filter(b -> b.getId() == id).findAny().orElse(null);
		}
		return null;
	}

	@GetMapping("/findAllBooks")
	public List<Book> getAllBooks() {
		return list != null ? list : null;
	}

}
