package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.BookEntity;

public interface BookService {

	boolean addBookDetails(BookEntity orderRequest);

	boolean updateBookDetails(BookEntity orderRequestData);

	List<BookEntity> getBooksDetails();

	boolean deleteBookDetais(Integer customerId);

	Optional<BookEntity> findBookDetailsById(Integer customerId);

}
