package com.project.george.model.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.model.TbPatient;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TablePatientDaoImplTest {
	
	@Autowired
	TablePatientDao custmTablePatient;
	
	@Test
	public final void testListPatient(){
		System.out.println("Entreeee testListPatient");
		List<TbPatient> listAllPatient=custmTablePatient.listAllPatient();
		System.out.println("Cantidad de fila TEST : "+listAllPatient.size());
		for(TbPatient beanPatient:listAllPatient){
			System.out.println(beanPatient.getNamePatient()+"||"+beanPatient.getLastNamePatient()+"||"+beanPatient.getTbArea().getNameArea());
		}
	}
	
	@Test
	public final void testListPatientSpecific(){
		System.out.println("Entreeee testListPatientSpecific");
		TbPatient tbPatientBean=new TbPatient();
		tbPatientBean.setNamePatient("Alberto");
		tbPatientBean.setLastNamePatient("");
		tbPatientBean.setDni("45700739");
		List<TbPatient> listAllPatient=custmTablePatient.listAllPatientSpecific(tbPatientBean);
		System.out.println("Cantidad de fila TEST : "+listAllPatient.size());
		for(TbPatient beanPatient:listAllPatient){
			System.out.println(beanPatient.getNamePatient()+"||"+beanPatient.getLastNamePatient()+"||"+beanPatient.getTbArea().getNameArea());
		}
	}

}
