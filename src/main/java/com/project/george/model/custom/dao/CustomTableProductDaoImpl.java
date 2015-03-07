package com.project.george.model.custom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.project.george.model.TbProduct;


public class CustomTableProductDaoImpl implements CustomTableProductDao{
		
	
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
	return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	}
	
    public List<TbProduct> finProduct(int idValue){
		System.out.println("Entre a finProduct : "+idValue);
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(TbProduct.class).add(Restrictions.eq("id", idValue));
//		String query="from TbProduct where status=1 and id="+idValue;
		List<TbProduct> listTbProduct = (List<TbProduct>)criteria.list();
		session.getTransaction().commit();
		return listTbProduct;
	}

}
