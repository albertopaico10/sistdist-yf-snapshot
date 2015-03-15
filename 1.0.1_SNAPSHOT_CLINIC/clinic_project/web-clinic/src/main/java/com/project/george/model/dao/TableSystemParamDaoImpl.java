package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbSystemParam;

@Repository
public class TableSystemParamDaoImpl implements TableSystemParamDao {
	@Autowired
	SessionFactory sessionfactory;
		
	public TbSystemParam beanSystemParamSpecific(String nameParam) {
		String query="from TbSystemParam where status=1 and nameParam='"+nameParam+"'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbSystemParam> param=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+param.size());
		
		session.close();
		
		return param.get(0);
	}
	
	public void updateSystemParam(TbSystemParam tbSystemParamBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbSystemParamBean);
	}
}
