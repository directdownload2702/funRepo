package org.miscellaneous.tutorials.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.miscellaneous.tutorials.web.query.HibernateQuery;

public abstract class  GenericDaoImpl<Entity, ID extends Serializable> implements GenericDao<Entity, ID>{
	SessionFactory sessionFactory;
	Class<Entity> doaType;
	
	public GenericDaoImpl() {
	}
	
	void setDaoType(Class<Entity> daoType){
		this.doaType = daoType;
	}

	@Override
	public Entity getByID(ID id) {
		return ((List<Entity>) sessionFactory.getCurrentSession().createQuery(" FROM " + doaType.getName()).list()).get(0);
		
	}

	@Override
	public List<Entity> getList() {
		return (List<Entity>) sessionFactory.getCurrentSession().createQuery(" FROM " + doaType.getName()).list();
	}
		

	@Override
	public ID save(Entity entity) {
		return (ID) sessionFactory.getCurrentSession().save(entity);
		
	}
	
	public Entity findSingle(HibernateQuery query) {
		return ((List<Entity>) find(query)).get(0);
	}
	
	public List<Entity> find(HibernateQuery query) {
		Query createQuery = sessionFactory.getCurrentSession().createQuery(query.getQueryString());
		for(String key : query.getParameters().keySet()) {
			Object value = query.getParameters().get(key);
			createQuery.setParameter(key, value);
		}
		
		for(String key : query.getParameterLists().keySet()) {
			Collection<Object> value = query.getParameterLists().get(key);
			createQuery.setParameterList(key, value);
		}
		return (List<Entity>) createQuery.list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

}
