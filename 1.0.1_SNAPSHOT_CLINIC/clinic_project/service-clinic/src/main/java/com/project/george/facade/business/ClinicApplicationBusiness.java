package com.project.george.facade.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.george.bean.kardex.BeanResponseKardex;
import com.project.george.bean.kardex.BeanResponseListKardexDetail;
import com.project.george.bean.kardex.canonical.BeanRequestCanonicalKardex;
import com.project.george.bean.paciente.Patient;
import com.project.george.bean.presentation.BeanRequestPresentation;
import com.project.george.bean.presentation.BeanResponseListPresentation;
import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;

@Service
public interface ClinicApplicationBusiness {

	public String mensajeTest(String value)throws Exception;
	
	public BeanResponseProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseProduct deleteProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseProduct updateProduct(BeanRequestProduct beanProduct)throws Exception;
	
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
	
	public BeanResponseKardex findKardexByIdProduct(String idProduct)throws Exception;
	
	public BeanResponseKardex saveKardex(BeanRequestCanonicalKardex beanReqCanonicalKardex);
	
	public BeanResponseListKardexDetail listDetailKardex(String idKardex);
	
	public List<BeanResponseProduct> listProduct()throws Exception;
	
	public BeanResponseListPresentation listAllPresentationAndroid()throws Exception;
}
