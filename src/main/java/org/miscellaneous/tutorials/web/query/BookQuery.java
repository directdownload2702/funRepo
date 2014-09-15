package org.miscellaneous.tutorials.web.query;

public class BookQuery extends HibernateQuery{
	private static final String basicQuery = " FROM Book book ";

	public BookQuery() {
		super(basicQuery);
	}
	
	public BookQuery(String query) {
		super(query);
	}
	
	public void andCondition(String andCondition) {
		addAndCondition(andCondition);
	}
	
	public void orCondition(String orCondition) {
		addAndCondition(orCondition);
	}

}
