package org.miscellaneous.tutorials.dao;

import java.util.List;
import org.miscellaneous.tutorials.domain.Book;

public interface BookDao {
	public List<Book> getBooks();
	public Book getBook(long id);
}