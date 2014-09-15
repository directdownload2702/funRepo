package org.miscellaneous.tutorials.dao;

import java.io.Serializable;
import java.util.List;

import org.miscellaneous.tutorials.web.query.HibernateQuery;

public interface GenericDao <Entity, ID extends Serializable> {

	Entity getByID(ID id);
	List<Entity> getList();
	ID save(Entity entity);
	Entity findSingle(HibernateQuery query);
	List<Entity> find(HibernateQuery query);
}
