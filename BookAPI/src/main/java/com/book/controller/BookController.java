package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookEntity;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(path = "/createBook")
	public ResponseEntity<String> createOrder(@RequestBody BookEntity bookRequest) {
		boolean isOrderPlaced = this.bookService.addBookDetails(bookRequest);
		if (isOrderPlaced) {
			return new ResponseEntity<>("Book  details added Successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Unable to add  book details", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getCustomerDetails")
	public ResponseEntity<List<BookEntity>> getAllTutorials() {
		try {
			List<BookEntity> bookDetails = this.bookService.getBooksDetails();
			if (bookDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bookDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateCustDetails")
	public ResponseEntity<String> updateBookEntity(@RequestBody BookEntity bookRequest) {

		Optional<BookEntity> orderEntity = bookService
				.findBookDetailsById(bookRequest.getBookId());

		if (orderEntity.isPresent()) {
			boolean orderResponse = this.bookService.updateBookDetails(bookRequest);
			if (orderResponse) {
				return new ResponseEntity<>("Book Details Updated Successfully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Unable to update Book Details", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@DeleteMapping("/deleteBookDetails/{bookId}")
	public ResponseEntity<String> cancelOrder(@PathVariable Integer bookId) {
		boolean isCanceled = this.bookService.deleteBookDetais(bookId);
		if (isCanceled)
			return new ResponseEntity<>("Book Details Removed ", HttpStatus.OK);
		else
			return new ResponseEntity<>("Failed  to remove book details", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
