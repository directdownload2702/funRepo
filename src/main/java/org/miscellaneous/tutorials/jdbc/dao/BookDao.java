package org.miscellaneous.tutorials.jdbc.dao;

import org.miscellaneous.tutorials.domain.Book;

public interface BookDao {
	public Integer getTotalPages(long id);
	public Book getBook(long id);

}
