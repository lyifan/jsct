package com.wcg.training.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDao<T extends java.io.Serializable> {

	private Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

    @SuppressWarnings("unchecked")
	public List<T> getAll() {
    	return (List<T>)this.getCurrentSession()
    					.createCriteria(this.entityClass).list();
    }

    public T getById(int id) {
    	return this.getCurrentSession().get(this.entityClass, id);
    }
    
    public void save(T entity) {
    	this.getCurrentSession().save(entity);
    }
    
    public void deleteById(int id) {
    	Session currentSession = this.getCurrentSession();
		Query query = currentSession.createQuery("delete " + this.entityClass.getName() + " where id = :ID");
    	query.setParameter("ID", id);
    	 
    	query.executeUpdate();
    }
	
    protected Session getCurrentSession() {
    	return this.sessionFactory.getCurrentSession();
    }
}
