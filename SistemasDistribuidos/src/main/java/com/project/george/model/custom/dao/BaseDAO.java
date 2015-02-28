package com.project.george.model.custom.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport {
	/**
	 * Find the entity by the identifier
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> clazz, Serializable id) {
		logger.debug("FindById (" + clazz.getSimpleName() + ") : " + id);
		return (T) getHibernateTemplate().get(clazz, id);
	}

	/**
	 * Show the given parameters
	 * 
	 * @param params
	 */
	private void showParameters(Object... params) {
		int i = 0;
		for (Object param : params) {
			// logger.debug("Param " + i + " : " + param.toString());
			logger.debug("Param " + i + " : " + param); // epinedac
		}
	}

	/**
	 * Return a list of entities that match with the criteria given by the query
	 * and the params
	 * 
	 * @param clazz
	 * @param query
	 * @param params
	 * @return
	 */
	protected <T> List<T> find(Class<T> clazz, String query, Object... params) {
		List list = getHibernateTemplate().find(query, params);
		logger.debug("Find : " + query);
		showParameters(params);
		logger.debug("Found : " + ((list != null) ? list.size() : "null lista"));
		return list;
	}

	/**
	 * Return a number limited list of entities that match with the criteria
	 * given by the query and the params
	 * 
	 * @param clazz
	 * @param sql
	 * @param first
	 * @param max
	 * @param params
	 * @return
	 */
	protected <T> List<T> findLimited(Class<T> clazz, String sql,
			Integer first, Integer max, Object... params) {
		if (first == null && max == null) {
			return find(clazz, sql, params); // The regular form
		}
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(sql);
		if (first != null) {
			query.setFirstResult(first);
		}
		if (max != null) {
			query.setMaxResults(max);
		}
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List list = query.list();
		logger.debug("Find : " + query);
		showParameters(params);
		logger.debug("Found : " + list.size());
		return list;
	}

	/**
	 * Resolve the hibernate connections. When an entity is loaded from the
	 * database, and the connection with another entities is lazy type (or proxy
	 * type), the related entities is not loaded yet, until this is explicitly
	 * used by the application in the transaction scope. To load this, we need
	 * 'initializate' the proxies connection
	 * 
	 * @param object
	 */
	public void initialize(Object object) {
		getHibernateTemplate().initialize(object);
	}

	/**
	 * Save the entity, this is, notify to hibernate that this entity is changed
	 * and require serialization. The real change is given when Hibernate make
	 * the commit at the end of the transaction, OR, this changes are ignored if
	 * an exception produce a rollback.
	 * 
	 * @param entity
	 */
	

	/**
	 * A difference of the simple save, this method, first evaluate if the
	 * entity exists, then update from the given entity parameter, if not
	 * exists, create a new in the database. This is created in the hibernate
	 * cache until the transaction finish with a commit or a rollback.
	 * 
	 * @param entity
	 */
	
	/**
	 * Normalize the dates
	 * @param entity
	 */

	
	
	
	/**
	 * Delete
	 * 
	 * @param entity
	 */
	public void delete(String sql,Object... params) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(sql);
		
		for(int i=0;params.length>i;i++){
			Object param =(Object)params[i];
			query.setParameter(i, param);
		}
	
		logger.debug("Query : " + query);
		
		int row = query.executeUpdate();
		
		if (row == 0){
			logger.debug("Doesn't deleted any row!");
		}
		else{
			logger.debug("Deleted Row: " + row);
		}
	}
	/**
	 * This Method return the class especific
	 * 
	 * */
	
	public <T> T findByIdWithout(Class<T> clazz) {
		logger.debug("FindById (" + clazz.getSimpleName() + ") ");		
		return (T) getHibernateTemplate().loadAll(clazz);
	}
	public void update(String sql,Object... params) {
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(sql);
		
		for(int i=0;params.length>i;i++){
			Object param =(Object)params[i];
			query.setParameter(i, param);
		}
	
		logger.debug("Query : " + query);
		
		int row = query.executeUpdate();
		
		if (row == 0){
			logger.debug("Doesn't deleted any row!");
		}
		else{
			logger.debug("Deleted Row: " + row);
		}
	}
	public <T> T calculatedColumns(String sql,Object... params){
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession()
		.createQuery(sql);

		for(int i=0;params.length>i;i++){
			Object param =(Object)params[i];
			query.setParameter(i, param);
		}		
	    List list = query.list();
	    
		return (T)list.get(0);
	}
}
