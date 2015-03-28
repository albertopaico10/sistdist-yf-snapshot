package com.project.george.facade.service.impl;

import java.net.URL;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.IDResolver;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.facade.service.ProductService;
import com.project.george.util.CommonConstants;
import com.project.george.util.UtilWebService;

@Service
public class ProductServiceImpl implements ProductService {
	
//	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	public String rucService = CommonConstants.PRODUCT_SOAP;
	
	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception {
//		logger.info(CommonConstants.Logger.LOGGER_START);
		try {
			
			Call objCall = UtilWebService.getCallService(rucService);
			
			objCall.setSOAPActionURI("http://tempuri.org/IProducto/crearProducto");

			objCall.setOperationName(new QName("http://tempuri.org/","crearProducto"));

			objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
			
//			 objCall.registerTypeMapping(Object.class, new QName("http://tempuri.org/"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			
			objCall.addParameter("nameProduct", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.addParameter("status", XMLType.XSD_INT, ParameterMode.IN);
			objCall.addParameter("idPresentacion", XMLType.XSD_INT, ParameterMode.IN);
			objCall.addParameter("priceProduct", XMLType.XSD_DECIMAL, ParameterMode.IN);
			objCall.addParameter("dateCreated", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.addParameter("priceSale", XMLType.XSD_DECIMAL, ParameterMode.IN);
			objCall.addParameter("expirationDate", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.setReturnType(XMLType.XSD_INT);
//			objCall.setReturnClass(Object.class);
						
			Object[] paramValues = new Object[]{
					beanProduct.getNameProduct(),
					beanProduct.getStatus(),
					beanProduct.getIdPresentation(),
					beanProduct.getPrice(),
					"2015-03-16",
					beanProduct.getPriceSale(),
					"2015-03-16"};
			
//			 logger.info(" getNameProduct ---> "+paramValues[0]);
//			    logger.info(" getStatus ---> "+paramValues[1]);
//			    logger.info(" getIdPresentation ---> "+paramValues[2]);
//			    logger.info(" getPrice ---> "+paramValues[3]);
//			    logger.info(" getExpirationDate ---> "+paramValues[4]);
//			    logger.info(" getPriceSale ---> "+paramValues[5]);
//			    logger.info(" getExpirationDate ---> "+paramValues[6]);
			
//			Object resultado=(Object)objCall.invoke(paramValues);
			int resultado=(Integer)objCall.invoke(paramValues);
//			for(RiesgoDTO serv : riesgoDTOs){
//				lstRiesgoDTO.add(serv);
//			}
		} catch (Exception e) {
			System.out.println("Error - " + this.getClass().getName() + ".anularReserva(): " + e.getMessage());
            e.printStackTrace();
//            resultado = -1;
		}
//		logger.info(CommonConstants.Logger.LOGGER_END);
		
		return null;
	}

	public boolean verificationExistProduct(String name,int idPresentation)throws Exception {
		Call objCall = UtilWebService.getCallService(rucService);
		
		objCall.setSOAPActionURI("http://tempuri.org/IProducto/validarExistenciaProducto");

		System.out.println("Load parameters");
		objCall.setOperationName(new QName("http://tempuri.org/","validarExistenciaProducto"));
		
		objCall.setOption( org.apache.axis.AxisEngine.PROP_DOMULTIREFS, new java.lang.Boolean( false) );
			
		objCall.addParameter("idPresentacion", XMLType.XSD_INT, ParameterMode.IN);
		objCall.addParameter("nombreProduct", XMLType.XSD_STRING, ParameterMode.IN);
		
		Object[] paramValues = new Object[]{
				idPresentation,
				name};
		
		boolean resultado=(Boolean)objCall.invoke(paramValues);
		System.out.println("Fin de servicio : "+resultado);
		
		return false;
	}

}
