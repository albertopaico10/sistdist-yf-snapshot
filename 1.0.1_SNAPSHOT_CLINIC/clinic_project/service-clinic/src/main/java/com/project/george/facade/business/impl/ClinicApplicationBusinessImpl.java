package com.project.george.facade.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.paciente.Patient;
import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponseListPresentation;
import com.project.george.bean.catalog.presentation.BeanResponsePresentation;
import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.bean.catalog.product.BeanResponseListProduct;
import com.project.george.bean.catalog.product.BeanResponseProduct;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.facade.service.PatientService;
import com.project.george.facade.service.PresentationService;
import com.project.george.facade.service.ProductService;
import com.project.george.util.CommonConstants;

@Service
public class ClinicApplicationBusinessImpl implements ClinicApplicationBusiness {
//	public Logger logger=Logger.getLogger(ClinicApplicationBusinessImpl.class);
	
	@Autowired
	public ProductService productService;
	@Autowired
	public PresentationService presentationService;
	@Autowired
	public PatientService patientService;
	
	public String mensajeTest(String value) throws Exception {
//		logger.info(CommonConstants.Logger.LOGGER_START);
		System.out.println(CommonConstants.Logger.LOGGER_START);
		return "HOLA .... "+value;
	}

	public BeanResponseProduct saveProduct(BeanRequestProduct beanProduct)throws Exception {
	/*	System.out.println(CommonConstants.Logger.LOGGER_START);
		//--Validate if Exist Producto with same Presentation
		boolean validationProduct=productService.verificationExistProduct(beanProduct.getNameProduct(),beanProduct.getIdPresentation());
		//--End
		BeanResponseProduct responseProduct=new BeanResponseProduct();
		if(!validationProduct){
			//--Save Product
			responseProduct=productService.saveProduct(beanProduct);
			responseProduct.setResult("redirect:/listProduct.htm");
		}		
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return responseProduct;*/
		return productService.saveProduct(beanProduct);
	}

	public BeanResponseListPresentation savePresentation(BeanRequestPresentation beanRequestPresentation) throws Exception {
		//--Save Presentation
		BeanResponsePresentation beanResponsePresentation=presentationService.savePresentationService(beanRequestPresentation);
		//--List Presentation
		BeanResponseListPresentation beanListPresentation=presentationService.listAllPresentation();
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS.equals(beanListPresentation.getResult())){
			beanListPresentation.setResult(beanResponsePresentation.getResult());
		}
		
		return beanListPresentation;
	}
	
	public BeanResponseListPresentation listAllPresentation()throws Exception{
		System.out.println(CommonConstants.Logger.LOGGER_START+"*** ClinicApplicationBusinessImpl.class");
		//--List Presentation in Status 1
		return presentationService.listAllPresentation();
	}

	public BeanResponseListPresentation updatePresentation(BeanRequestPresentation beanRequestPresentation) throws Exception {
		//--Consult Presentation
		BeanResponsePresentation beanResponse=presentationService.consultPresentationService(beanRequestPresentation);
//		BeanResponsePresentation beaResponseUpdate=null;
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS.equals(beanResponse.getResult())){
			//--Update Presentation
			System.out.println("************************* UPDATE : "+beanRequestPresentation.getNamePresentation());
			beanRequestPresentation.setNamePresentation(beanRequestPresentation.getNamePresentation());
			beanRequestPresentation.setStatus(beanResponse.getStatus());
			beanRequestPresentation.setDateCreated(beanResponse.getDateCreated());
			
			BeanResponsePresentation beaResponseUpdate=presentationService.updatePresentationService(beanRequestPresentation);
		}
		//--List Presentation
		BeanResponseListPresentation beanListPresentation=presentationService.listAllPresentation();
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS.equals(beanListPresentation.getResult())){
			beanListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_UPDATE);
		}	
		return beanListPresentation;
	}

	public BeanResponseListPresentation deletePresentation(BeanRequestPresentation beanRequestPresentation) throws Exception {
		//--Consult Presentation
		BeanResponsePresentation beanResponse=presentationService.consultPresentationService(beanRequestPresentation);
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS.equals(beanResponse.getResult())){
			//--Update Presentation
			beanRequestPresentation.setNamePresentation(beanResponse.getNamePresentation());
			beanRequestPresentation.setStatus(2);
			beanRequestPresentation.setDateCreated(beanResponse.getDateCreated());
			
			BeanResponsePresentation beaResponseUpdate=presentationService.updatePresentationService(beanRequestPresentation);
		}
		//--List Presentation
		BeanResponseListPresentation beanListPresentation=presentationService.listAllPresentation();
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS.equals(beanListPresentation.getResult())){
			beanListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_DELETE);
		}	
		return beanListPresentation;
	}
	
	public BeanResponseListProduct listProductByName(String nameProduct)throws Exception{
		
		return productService.listProductByName(nameProduct);
	}
	
	public Patient savePatient(Patient patient) {
		return patientService.savePatient(patient);
	}

	public Patient updatePatient(Patient patient) {
		return patientService.updatePatient(patient);
	}

	public Patient getPatient(Integer id) {
		return patientService.getPatient(id);
	}

	public String removePatient(Integer id) {
		return patientService.removePatient(id);
	}

	public List<Patient> getPatients() {
		return patientService.getPatients();
	}

}
