package org.miscellaneous.tutorials.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.miscellaneous.tutorials.domain.Book;

public class BookDaoImpl implements BookDao {
	
	SessionFactory sessionFactory;
	
		
	@Override
	public List<Book> getBooks() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Book");
		List<Book> book = (List<Book>) query.list();
		return book;
	}

	@Override
	public Book getBook(long id) {
		return (Book) sessionFactory.getCurrentSession().createQuery("FROM Book where id = " + id).list().get(0);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	

}
