package com.book.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOOK_DETAILS")
@Data
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private Integer bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_PRICE")
	private String bookPrice;

	@Column(name = "BOOK_AUTHORNAME")
	private String authorName;
	
	@Column(name = "BOOK_PUBDATE")
	private String publishDate;

}
