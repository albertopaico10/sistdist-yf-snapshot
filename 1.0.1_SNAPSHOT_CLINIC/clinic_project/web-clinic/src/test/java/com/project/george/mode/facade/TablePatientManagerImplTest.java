package com.project.george.mode.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.model.facade.TablePatientManager;
import com.project.george.model.facade.TablePatientManagerImpl;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TablePatientManagerImplTest {
	
	@Test
	public void codeHistory()throws Exception{
		
//		System.out.println("Dentro del metodo");
//		TablePatientManagerImpl tablePatientImpl=new TablePatientManagerImpl();
////		String codeHistory=tablePatientImpl.get
//		System.out.println("Valor de Codigo de Clinica : "+codeHistory);
	}
	
}
