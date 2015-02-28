package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbArea;

@Repository
public class TableAreaDaoImpl implements TableAreaDao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public List<TbArea> listAllAreas() {
		String query="from TbArea where status=1";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbArea> areaList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+areaList.size());
		
		session.close();
		
		return areaList;
	}
	
	public TbArea beanAreaSpecific(int idArea) {
		String query="from TbArea where status=1 and id='"+idArea+"'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbArea> areaList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+areaList.size());
		
		session.close();
		
		return areaList.get(0);
	}
	
	public void addNewArea(TbArea tbAreaBean) {
		tbAreaBean.setStatus(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbAreaBean);		
	}
	
	public void deleteArea(TbArea tbAreaBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbAreaBean);
	}
}
