package org.miscellaneous.tutorials.jdbc;

import org.miscellaneous.tutorials.domain.Book;
import org.miscellaneous.tutorials.jdbc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookJdbcTemplate implements BookDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Integer getTotalPages(long id) {
		String query = "Select total_pages from book where id = ?";
		int totalPages = jdbcTemplate.queryForInt(query, id);
		return totalPages;
	}

	@Override
	public Book getBook(long id) {
		return null;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Required
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
