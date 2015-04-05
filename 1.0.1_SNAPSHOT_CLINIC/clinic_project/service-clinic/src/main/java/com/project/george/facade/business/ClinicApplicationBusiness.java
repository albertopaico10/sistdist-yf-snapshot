package com.project.george.facade.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.paciente.Patient;
import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponseListPresentation;
import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.bean.catalog.product.BeanResponseListProduct;
import com.project.george.bean.catalog.product.BeanResponseProduct;

@Service
public interface ClinicApplicationBusiness {

	public String mensajeTest(String value)throws Exception;
	
	public BeanResponseProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseListPresentation savePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation listAllPresentation()throws Exception;
	
	public BeanResponseListPresentation updatePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation deletePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;

	public BeanResponseListProduct listProductByName(String nameProduct)throws Exception;
	
	public Patient savePatient(Patient patient);
	
	public Patient updatePatient(Patient patient);
	
	public Patient getPatient(Integer id);
	
	public String removePatient(Integer id);
	
	public List<Patient> getPatients();
}
