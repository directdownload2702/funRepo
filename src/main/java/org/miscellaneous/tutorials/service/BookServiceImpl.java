package org.miscellaneous.tutorials.service;

import java.util.List;

import javax.transaction.Transactional;
import org.miscellaneous.tutorials.dao.GBookDaoImpl;
import org.miscellaneous.tutorials.dao.GenericDao;
import org.miscellaneous.tutorials.domain.Book;
import org.miscellaneous.tutorials.web.query.HibernateQuery;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService{
	
	@Autowired
	GenericDao<Book, Long> gBookDaoImpl;

	@Override
	@Transactional
	public List<Book> getBooks() {
		return gBookDaoImpl.getList();
	}
	
	@Override
	@Transactional
	public Long save(Book book) {
		return gBookDaoImpl.save(book);
	}

	@Override
	@Transactional
	public Book getBook(long id) {
		return gBookDaoImpl.getByID(id);
	}

	@Override
	@Transactional
	public List<Book> getBooks(HibernateQuery query) {
		return gBookDaoImpl.find(query);
	}

	@Override
	public Book getBook(HibernateQuery query) {
		return gBookDaoImpl.findSingle(query);
	}

	public GenericDao getgBookDaoImpl() {
		return gBookDaoImpl;
	}
	
	
	public void setGenericDao(GBookDaoImpl gBookDaoImpl) {
		this.gBookDaoImpl = gBookDaoImpl;
	}
}
