package org.miscellaneous.tutorials.service;

import java.util.List;

import org.miscellaneous.tutorials.domain.Book;
import org.miscellaneous.tutorials.web.query.HibernateQuery;

public interface BookService {
	public List<Book> getBooks();
	public Book getBook(long id);
	public Long save(Book book);
	public List<Book> getBooks(HibernateQuery query);
	public Book getBook(HibernateQuery query);
}
