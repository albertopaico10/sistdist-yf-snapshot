package com.project.george.facade.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.george.bean.kardex.BeanResponseKardex;
import com.project.george.bean.kardex.BeanResponseKardexDetail;
import com.project.george.bean.kardex.BeanResponseListKardexDetail;
import com.project.george.bean.kardex.canonical.BeanRequestCanonicalKardex;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalKardexDetail;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalListDetailKardex;
import com.project.george.bean.paciente.Patient;
import com.project.george.bean.presentation.BeanRequestPresentation;
import com.project.george.bean.presentation.BeanResponseListPresentation;
import com.project.george.bean.presentation.BeanResponsePresentation;
import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;
import com.project.george.bean.product.canonical.BeanResponseCanonicalListProduct;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.facade.service.KardexService;
import com.project.george.facade.service.PatientService;
import com.project.george.facade.service.PresentationService;
import com.project.george.facade.service.ProductService;
import com.project.george.facade.service.impl.PresentationServiceImpl;
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
	@Autowired
	public KardexService kardexService;
	
	
	
	public String mensajeTest(String value) throws Exception {
//		logger.info(CommonConstants.Logger.LOGGER_START);
		System.out.println(CommonConstants.Logger.LOGGER_START);
		return "HOLA .... "+value;
	}

	public BeanResponseProduct saveProduct(BeanRequestProduct beanProduct)throws Exception {

		return productService.saveProduct(beanProduct);
	}
	
	public BeanResponseProduct deleteProduct(BeanRequestProduct beanProduct)throws Exception {
	
		return productService.deleteProduct(beanProduct);
	}
	
	public BeanResponseProduct updateProduct(BeanRequestProduct beanProduct)throws Exception {
		
		return productService.updateProduct(beanProduct);
	}
	
	public BeanResponseListPresentation savePresentation(BeanRequestPresentation beanRequestPresentation) throws Exception {
		//--Save Presentation
		BeanResponsePresentation beanResponsePresentation=presentationService.savePresentationService(beanRequestPresentation);
		//--List Presentation
		BeanResponseListPresentation beanListPresentation=presentationService.listAllPresentation();
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_LIST.equals(beanListPresentation.getResult())){
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
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_LIST.equals(beanListPresentation.getResult())){
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
		if(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_LIST.equals(beanListPresentation.getResult())){
			beanListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_DELETE);
		}	
		return beanListPresentation;
	}
	
	public BeanResponseListProduct listProductByName(String nameProduct)throws Exception{
		
		return productService.listProductByName(nameProduct);
	}
	public BeanResponseCanonicalListProduct listProduct()throws Exception{
		
		return productService.listProduct();
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
	
	public BeanResponseKardex findKardexByIdProduct(String idProduct)throws Exception{
		return kardexService.listKardexByProduct(idProduct);
	}
	
	public BeanResponseKardex saveKardex(BeanRequestCanonicalKardex beanReqCanonicalKardex){
		System.out.println(CommonConstants.Logger.LOGGER_START+"** saveKardex");
		BeanResponseKardex beanResponse=new BeanResponseKardex();
		try {
			 beanResponse=kardexService.saveKardexService(beanReqCanonicalKardex);
			 String messages=beanResponse.getMessages();
			 //--Listar Kardex
			 BeanResponseKardex beanResponseListKardex=kardexService.listKardexByProduct(String.valueOf(beanReqCanonicalKardex.getIdProduct()));
			 if(CommonConstants.ResponseWebService.RESP_WS_EXIST.equals(beanResponseListKardex.getResult())){
//				 beanResponse.setResult(CommonConstants.ResponseWebService.RESP_WS_NOT_EXIST);
				 beanResponse=beanResponseListKardex;
				 if(messages!=null&&CommonConstants.ResponseWebService.RESP_WS_MESSAGES_INSUFFICIENT_PRODUCT.equals(messages)){
					 beanResponse.setResult(CommonConstants.ResponseWebService.RESP_WS_SUCCESS_SAVE);
					 beanResponse.setMessages(CommonConstants.ResponseWebService.RESP_WS_MESSAGES_INSUFFICIENT_PRODUCT);
				 }else{
					 beanResponse.setResult(CommonConstants.ResponseWebService.RESP_WS_SUCCESS_SAVE); 
				 }				 
			 }
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			beanResponse.setResult(CommonConstants.ResponseWebService.RESP_WS_ERROR);
		}
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanResponse;
	}

	public BeanResponseListKardexDetail listDetailKardex(String idKardex){
		
		BeanResponseListKardexDetail beanRespListKardexDetail=new BeanResponseListKardexDetail();
		
		List<BeanResponseKardexDetail> listBeanRespKardDet=new ArrayList<BeanResponseKardexDetail>();
		BeanResponseCanonicalListDetailKardex beanListKardexDetail=kardexService.listDetailKardex(idKardex);
		for(BeanResponseCanonicalKardexDetail beanRespCanonicalKardexDetail:beanListKardexDetail.getListDetailKardex()){
			
			BeanResponseKardexDetail beanResponseKardexDet=new BeanResponseKardexDetail();
			beanResponseKardexDet.setId(beanRespCanonicalKardexDetail.getId());
			beanResponseKardexDet.setCantidad(beanRespCanonicalKardexDetail.getCantidad());
			beanResponseKardexDet.setComprobanteClase(beanRespCanonicalKardexDetail.getComprobanteClase());
			beanResponseKardexDet.setComprobanteNumero(beanRespCanonicalKardexDetail.getComprobanteNumber());
			beanResponseKardexDet.setIdKardex(beanRespCanonicalKardexDetail.getIdKardex());
			beanResponseKardexDet.setPriceProduct(beanRespCanonicalKardexDetail.getPriceProduct());
			beanResponseKardexDet.setPriceSale(beanRespCanonicalKardexDetail.getPriceSale());
			beanResponseKardexDet.setStatus(beanRespCanonicalKardexDetail.getStatus());
			beanResponseKardexDet.setTypeOperation(beanRespCanonicalKardexDetail.getTypeOperation());
			beanResponseKardexDet.setDateCreated(beanRespCanonicalKardexDetail.getDateCreated());

			listBeanRespKardDet.add(beanResponseKardexDet);
		}
		System.out.println("Cantidad de registros : "+listBeanRespKardDet.size());
		beanRespListKardexDetail.setListDetailKardex(listBeanRespKardDet);
		return beanRespListKardexDetail;
	}

//	public BeanResponseListProduct listProductByName(String nameProduct)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public BeanResponseListPresentation listAllPresentationAndroid()throws Exception{
		System.out.println("Dentro de listAllPresentationAndroid");
		PresentationService presentationServiceAnd=new PresentationServiceImpl();
		return presentationServiceAnd.listAllPresentation();
	} 
}
