package org.miscellaneous.tutorials.dao;

import org.miscellaneous.tutorials.domain.Book;

public class GBookDaoImpl extends GenericDaoImpl<Book, Long>{
	
	public GBookDaoImpl() {
		setDaoType(Book.class);
	}
	
}
