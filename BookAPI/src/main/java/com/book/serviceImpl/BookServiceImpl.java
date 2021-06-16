package com.book.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookEntity;
import com.book.repository.BookRepository;
import com.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public boolean addBookDetails(BookEntity orderRequest) {
		BookEntity orderData = this.bookRepository.save(orderRequest);
		return orderData.getBookId() != null;
	}

	@Override
	public boolean updateBookDetails(BookEntity orderRequestData) {
		BookEntity orderData = this.bookRepository.save(orderRequestData);
		return orderData.getBookId() != null;

	}

	@Override
	public List<BookEntity> getBooksDetails() {
		return this.bookRepository.findAll();
	}

	@Override
	public boolean deleteBookDetais(Integer bookId) {
		try {
			this.bookRepository.deleteById(bookId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Optional<BookEntity> findBookDetailsById(Integer bookId) {
		return this.bookRepository.findById(bookId);
	}
}
