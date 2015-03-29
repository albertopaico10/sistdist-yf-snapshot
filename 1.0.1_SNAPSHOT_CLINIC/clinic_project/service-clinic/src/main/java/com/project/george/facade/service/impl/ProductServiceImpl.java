package com.project.george.facade.service.impl;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.IDResolver;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.bean.catalog.product.BeanResponseListProduct;
import com.project.george.bean.catalog.product.canonical.BeanResponseCanonicalListProduct;
import com.project.george.bean.catalog.product.canonical.BeanResponseCanonicalProduct;
import com.project.george.facade.service.ProductService;
import com.project.george.util.CommonConstants;
import com.project.george.util.JsonUtils;
import com.project.george.util.UtilWebService;

@Service
public class ProductServiceImpl implements ProductService {
	
//	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	public String rucService = CommonConstants.PRODUCT_SOAP;
	
	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception {
		System.out.println(CommonConstants.Logger.LOGGER_START);
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
			
			 System.out.println(" getNameProduct ---> "+paramValues[0]);
			    System.out.println(" getStatus ---> "+paramValues[1]);
			    System.out.println(" getIdPresentation ---> "+paramValues[2]);
			    System.out.println(" getPrice ---> "+paramValues[3]);
			    System.out.println(" getExpirationDate ---> "+paramValues[4]);
			    System.out.println(" getPriceSale ---> "+paramValues[5]);
			    System.out.println(" getExpirationDate ---> "+paramValues[6]);
			
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
		System.out.println(CommonConstants.Logger.LOGGER_END);
		
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
	
	public BeanResponseListProduct listProductByName(String nameProduct)throws Exception{
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseListProduct beanListProduct=new BeanResponseListProduct();
		
		String URL="http://localhost:53924/KardexService.svc/FindProductByName/";
		BeanResponseCanonicalListProduct listProduct=restTemplate.getForObject(URL+nameProduct, BeanResponseCanonicalListProduct.class);
		
		System.out.println("Respuesta del servicio : "+listProduct.getListCadenaProduct());
		System.out.println("Respuesta RESULT del servicio : "+listProduct.getResult());
		if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(listProduct.getResult())){
			beanListProduct=JsonUtils.jsonToJavaObject(listProduct.getListCadenaProduct(),BeanResponseListProduct.class);
			beanListProduct.setResult(CommonConstants.ResponseWebLayer.RESP_SL_SUCCESS);
		}
		return beanListProduct;
	}
}
