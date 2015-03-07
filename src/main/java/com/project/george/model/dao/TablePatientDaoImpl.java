package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbArea;
import com.project.george.model.TbPatient;

@Repository
public class TablePatientDaoImpl implements TablePatientDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public void addNewPatient(TbPatient tbPatientBean) {	
		tbPatientBean.setStatusPatient(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbPatientBean);
	}

	public List<TbPatient> listAllPatient() {
		String query="from TbPatient where statusPatient=1";
		
		Session session=sessionfactory.openSession();
		
		List<TbPatient> patientList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+patientList.size());
		
		session.close();
		
		return patientList;
	}
	
	public List<TbPatient> listAllPatientSpecific(TbPatient tbPatientBean){
		String query="from TbPatient where statusPatient=1 and namePatient like '%"+tbPatientBean.getNamePatient()+"%' and lastNamePatient like '%"+tbPatientBean.getLastNamePatient()+"%' and dni like '%"+tbPatientBean.getDni()+"%'";
		
		Session session=sessionfactory.openSession();
		
		List<TbPatient> patientList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+patientList.size());
		
		session.close();
		
		return patientList;
		
	}

	public void deleteArea(TbPatient tbPatientBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbPatientBean);
	}

	public TbPatient beanPatientSpecific(int idPatient) {
		String query="from TbPatient where statusPatient=1 and id='"+idPatient+"'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbPatient> patientList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+patientList.size());
		
		session.close();
		
		return patientList.get(0);
	}
}
