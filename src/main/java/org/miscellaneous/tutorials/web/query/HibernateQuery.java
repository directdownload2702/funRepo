package org.miscellaneous.tutorials.web.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class HibernateQuery implements Query{
	String query;
	Set<String> andConditions;
	Set<String> orConditions;
	Map<String, Object> parameters;
	Map<String, Collection<Object>> parameterLists;
	String orderBy;
	private static final String ORDER_BY_EXPRESSION = "order by";
	
	public HibernateQuery(String query) {
		this.query = query;
		andConditions = new HashSet<String>();
		orConditions = new HashSet<String>();
		parameters = new HashMap<String, Object>();
		parameterLists = new HashMap<String, Collection<Object>>();
	}
	
	public void addAndCondition(String condition) {
		andConditions.add(condition);
	}
	
	public void addORCondition(String condition) {
		orConditions.add(condition);
	}
	
	public void addParameter(String key, Object value) {
		parameters.put(key, value);
	}
	
	public void addParameterList(String key, Collection value) {
		parameterLists.put(key, value);
	}	
	
	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	public Map<String, Collection<Object>> getParameterLists() {
		return parameterLists;
	}
	
	public void addOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	@Override
	public String getQueryString() {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append(query);
		if(queryBuffer.toString().trim().lastIndexOf(ORDER_BY_EXPRESSION) > 0) {
			queryBuffer = (StringBuffer) queryBuffer.subSequence(0, queryBuffer.toString().trim().lastIndexOf(ORDER_BY_EXPRESSION));
		}
		
		for (String condition : andConditions) {
			if(queryBuffer.toString().toUpperCase().lastIndexOf("WHERE") > 0) {
				queryBuffer.append(" AND " + condition);
			} else {
				queryBuffer.append(" WHERE " + condition); 
			}
		}
		
		for (String condition : orConditions) {
			if(queryBuffer.toString().toUpperCase().lastIndexOf("WHERE") > 0) {
				queryBuffer.append(" OR " + condition);
			} else {
				queryBuffer.append(" WHERE " + condition); 
			}
		}
		
		if(orderBy != null) {
			queryBuffer.append(" order by " + orderBy);
		}
		return queryBuffer.toString();
	}
	
}
