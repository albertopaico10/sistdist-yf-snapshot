package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbArea;
import com.project.george.model.TbPresentation;

@Repository
public class TablePresentationDaoImpl implements TablePresentationDao{
	
	@Autowired
	SessionFactory sessionfactory;
	
	public List<TbPresentation> listAllPresentation() {
		String query="from TbPresentation where status=1";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbPresentation> presentationList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+presentationList.size());
		
		session.close();
		
		return presentationList;
	}

	public void addNewPresentation(TbPresentation tbPresentationBean) {
		tbPresentationBean.setStatus(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbPresentationBean);			
	}
	
	public TbPresentation beanPresentationSpecific(int idPresentation) {
		String query="from TbPresentation where status=1 and id='"+idPresentation+"'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbPresentation> presentationList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+presentationList.size());
		
		session.close();
		
		return presentationList.get(0);
	}
	
	public void deletePresentation(TbPresentation tbPresentationBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbPresentationBean);
	}
	
}
