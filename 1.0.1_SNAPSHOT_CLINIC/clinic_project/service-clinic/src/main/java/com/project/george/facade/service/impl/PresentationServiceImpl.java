package com.project.george.facade.service.impl;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.stereotype.Service;

import com.project.george.bean.presentation.BeanRequestPresentation;
import com.project.george.bean.presentation.BeanResponseListPresentation;
import com.project.george.bean.presentation.BeanResponsePresentation;
import com.project.george.bean.presentation.canonical.BeanListPresentation;
import com.project.george.bean.presentation.canonical.BeanResponseCanonicalListPresentation;
import com.project.george.bean.presentation.canonical.BeanResponseCanonicalPresentation;
import com.project.george.facade.service.PresentationService;
import com.project.george.util.CommonConstants;
import com.project.george.util.JsonUtils;
import com.project.george.util.UtilWebService;

@Service
public class PresentationServiceImpl implements PresentationService {
	
//	private static Logger logger = Logger.getLogger(PresentationServiceImpl.class);
	public String rucService = CommonConstants.PRODUCT_SOAP;
	
	public BeanResponsePresentation savePresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception {
		System.out.println(CommonConstants.Logger.LOGGER_START+"***PresentationServiceImpl");
		BeanResponsePresentation beanResponsePresentation=new BeanResponsePresentation();
		BeanResponseCanonicalPresentation beanResponseWS=null;
		try {
			Call objCall = UtilWebService.getCallService(rucService);
			
			objCall.setSOAPActionURI("http://tempuri.org/IProducto/crearPresentacion");
			
			objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
			
			objCall.registerTypeMapping(BeanResponseCanonicalPresentation.class, new QName("http://tempuri.org/"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://tempuri.org/","crearPresentacion"));
			objCall.addParameter("namePresentation", XMLType.XSD_STRING, ParameterMode.IN);
			
			objCall.setReturnClass(BeanResponseCanonicalPresentation.class);
			
			beanResponseWS =  (BeanResponseCanonicalPresentation) objCall.invoke(new Object[]{beanRequestPresentation.getNamePresentation()});

			if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(beanResponseWS.Result)){
				beanResponsePresentation.setId(beanResponseWS.Id);
				beanResponsePresentation.setStatus(beanResponseWS.Status);
				beanResponsePresentation.setNamePresentation(beanResponseWS.NamePresentation);
				beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS);
			}
			
		} catch (Exception e) {
			 System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + e.getMessage());
	         e.printStackTrace();
	         beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_NOTWORKING);
		}
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanResponsePresentation;
	}

	public BeanResponseListPresentation listAllPresentation()throws Exception {
		System.out.println(CommonConstants.Logger.LOGGER_START);
		BeanResponseListPresentation responseListPresentation=new BeanResponseListPresentation();
		BeanResponseCanonicalListPresentation beanResponseWS=null;
		try {
			System.out.println("1");
			Call objCall = UtilWebService.getCallService(rucService);
			System.out.println("2");
			objCall.setSOAPActionURI("http://tempuri.org/IProducto/listarPresentacionObj");
			System.out.println("3");
			objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
			System.out.println("4");
			objCall.registerTypeMapping(BeanResponseCanonicalListPresentation.class, new QName("http://tempuri.org/"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			System.out.println("5");
			objCall.setOperationName(new QName("http://tempuri.org/","listarPresentacionObj"));
			System.out.println("6");
			objCall.setReturnClass(BeanResponseCanonicalListPresentation.class);
			System.out.println("7");
			beanResponseWS =  (BeanResponseCanonicalListPresentation) objCall.invoke(new Object[]{});
			System.out.println("8");
			if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(beanResponseWS.Result)){
				BeanListPresentation listBean=JsonUtils.jsonToJavaObject(beanResponseWS.strCadenaValues, BeanListPresentation.class);
				System.out.println("Cantida de registros Integration Layer : "+listBean.getResponse().size());
				responseListPresentation.setBeanListPresentation(listBean.getResponse());
				responseListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS);
			}
			else{
				responseListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_ERROR);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			responseListPresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_NOTWORKING);
		}
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return responseListPresentation;
	}
	
	public BeanResponsePresentation consultPresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception {
	System.out.println(CommonConstants.Logger.LOGGER_START);
	
	BeanResponsePresentation beanResponsePresentation=new BeanResponsePresentation();
	BeanResponseCanonicalPresentation beanResponseWS=null;
	try {
		Call objCall = UtilWebService.getCallService(rucService);
		
		objCall.setSOAPActionURI("http://tempuri.org/IProducto/consultarPresentacionObj");
		
		objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
		
		objCall.registerTypeMapping(BeanResponseCanonicalPresentation.class, new QName("http://tempuri.org/"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
		objCall.setOperationName(new QName("http://tempuri.org/","consultarPresentacionObj"));
		objCall.addParameter("idPresentacion", XMLType.XSD_STRING, ParameterMode.IN);
		
		objCall.setReturnClass(BeanResponseCanonicalPresentation.class);
		
		beanResponseWS =  (BeanResponseCanonicalPresentation) objCall.invoke(new Object[]{beanRequestPresentation.getId()});
		
		if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(beanResponseWS.Result)){
			beanResponsePresentation.setId(beanResponseWS.Id);
			beanResponsePresentation.setStatus(beanResponseWS.Status);
			beanResponsePresentation.setNamePresentation(beanResponseWS.NamePresentation);
			beanResponsePresentation.setDateCreated(beanResponseWS.DateCreated);
			beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS);
		}
	} catch (Exception e) {
		 System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + e.getMessage());
         e.printStackTrace();
         beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_NOTWORKING);
	}
	System.out.println(CommonConstants.Logger.LOGGER_END);
	return beanResponsePresentation;
	}

	public BeanResponsePresentation updatePresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception {
		System.out.println(CommonConstants.Logger.LOGGER_START);
		BeanResponsePresentation beanResponsePresentation=new BeanResponsePresentation();
		BeanResponseCanonicalPresentation beanResponseWS=null;
		try {
			Call objCall = UtilWebService.getCallService(rucService);
			
			objCall.setSOAPActionURI("http://tempuri.org/IProducto/actualizarPresentacion");
			
			objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
			
			objCall.registerTypeMapping(BeanResponseCanonicalPresentation.class, new QName("http://tempuri.org/"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			
			objCall.setOperationName(new QName("http://tempuri.org/","actualizarPresentacion"));
			
			objCall.addParameter("namePresentation", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.addParameter("status", XMLType.XSD_INT, ParameterMode.IN);
			objCall.addParameter("dateCreated", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.addParameter("idPresentation", XMLType.XSD_INT, ParameterMode.IN);
			
			objCall.setReturnClass(BeanResponseCanonicalPresentation.class);
			System.out.println("***** Name by Updated: "+beanRequestPresentation.getNamePresentation()+"****"+beanRequestPresentation.getId()
					+"*****"+beanRequestPresentation.getStatus()+"******"+beanRequestPresentation.getDateCreated());
			
			beanResponseWS =  (BeanResponseCanonicalPresentation) objCall.invoke(
					new Object[]{
							beanRequestPresentation.getNamePresentation(),
							beanRequestPresentation.getStatus(),
							beanRequestPresentation.getDateCreated(),
							beanRequestPresentation.getId()					
					});
			System.out.println("***************** RESULT : "+beanResponseWS.Result);
			if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(beanResponseWS.Result)){
				beanResponsePresentation.setId(beanResponseWS.Id);
				beanResponsePresentation.setStatus(beanResponseWS.Status);
				beanResponsePresentation.setNamePresentation(beanResponseWS.NamePresentation);
				System.out.println("RESPONSE C# SERVICES : "+beanResponsePresentation.getNamePresentation());
				beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS_UPDATE);
			}
			
		} catch (Exception e) {
			 System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + e.getMessage());
	         e.printStackTrace();
	         beanResponsePresentation.setResult(CommonConstants.ResponseWebLayer.RESP_SL_NOTWORKING);
		}
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanResponsePresentation;
	}
	
}
