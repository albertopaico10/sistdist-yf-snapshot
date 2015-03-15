package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbPatient;
import com.project.george.model.TbUser;

@Repository
public class TableUserDaoImpl implements TableUserDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<TbUser> validateUserAndPass(String user, String pass) {
		
		String query="from TbUser where UPPER(userName) ='"+user.toUpperCase()+"' and password = '"+pass+"' and status='1'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbUser> userList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+userList.size());
		session.close();
		return userList;
	}

	public void updateLastLogin(TbUser tbUserBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbUserBean);
		
	}

	public TbUser beanSpecific(String userName) {
		String query="from TbUser where UPPER(userName)='"+userName+"' and status=1";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbUser> userList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+userList.size());
		
		session.close();
		
		return userList.get(0);
	}
	
	
	
}
