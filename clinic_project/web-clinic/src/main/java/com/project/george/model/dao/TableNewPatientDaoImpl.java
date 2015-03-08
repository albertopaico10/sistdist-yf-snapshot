package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbNewPatient;
import com.project.george.model.TbPatient;

@Repository
public class TableNewPatientDaoImpl implements TableNewPatientDao {

	@Autowired
	SessionFactory sessionfactory;

	public List<TbNewPatient> listAllPatient() {
		String query="from TbNewPatient where statusPatient=1";
		
		Session session=sessionfactory.openSession();
		
		List<TbNewPatient> patientList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+patientList.size());
		
		session.close();
		
		return patientList;
	}

	public void addNewPatient(TbNewPatient tbPatientBean) {
		tbPatientBean.setStatusPatient(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbPatientBean);
		
	}

	public void deleteArea(TbNewPatient tbPatientBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbPatientBean);		
	}

	public TbNewPatient beanNewPatientSpecific(int idPatient) {
		String query="from TbNewPatient where statusPatient=1 and id='"+idPatient+"'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbNewPatient> patientList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+patientList.size());
		
		session.close();
		
		return patientList.get(0);
	}
	
	
}
