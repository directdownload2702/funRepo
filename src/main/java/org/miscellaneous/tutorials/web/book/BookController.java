package org.miscellaneous.tutorials.web.book;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.miscellaneous.tutorials.domain.Author;
import org.miscellaneous.tutorials.domain.Book;
import org.miscellaneous.tutorials.service.BookService;
import org.miscellaneous.tutorials.web.query.BookQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/book")
public class BookController {
	private static final String BOOK_TITLE_PARAM = "title";
	private static final String BOOK_IDS_PARAM = "ids";
	
	
	@Autowired
	BookService bookServiceImpl;
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	/**
	 * getBook() method.
	 * @return
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getBook(){
		List<Book> books = bookServiceImpl.getBooks();
		System.out.println("Book is: " + books.get(0).getTitle());
		
		Book book = (Book) bookServiceImpl.getBook(11);
		System.out.println("Book by id: " + book.getId() + "_" + book.getTitle() + " and author is: " + book.getAuthor().getFirstName());
		
		Author author = new Author();
		author.setFirstName("hFirstName");
		author.setLastName("hLastName");
		author.setEmailAddress("hEmail@email.com");
		Book saveBook = new Book();
		saveBook.setAuthor(author);
		saveBook.setTitle("Hibernate saved");
		saveBook.setTotalPages(22);
		System.out.println("Saving in db");
		
		BookQuery query = new BookQuery();
		query.addAndCondition(" book.id in (:" + BOOK_IDS_PARAM + ")");
		List<Long> ids = new ArrayList<Long>();
		ids.add(2L);
		ids.add(11L);
		query.addParameterList(BOOK_IDS_PARAM, ids);
		query.addOrderBy(" book.id DESC ");
		
		System.out.println(" Find book with HibernateQuery:");
		List<Book> retrievedBooks = bookServiceImpl.getBooks(query);
		displayBooks(retrievedBooks);
		
		//bookServiceImpl.save(saveBook);
		logger.info("returning home view");
		
		return new ModelAndView("home").addObject("name", "Mr. Spring");
	}
	
	public void displayBooks(List<Book> books) {
		System.out.println("Displaying list of Books: ");
		for(Book book : books) {
			System.out.println(" Book id: " + book.getId() + " title: " + book.getTitle() + " total pages: " + book.getTotalPages());
		}
	}
	
	public BookService getBookService() {
		return bookServiceImpl;
	}

	public void setBookService(BookService bookService) {
		this.bookServiceImpl = bookService;
	}
	
}