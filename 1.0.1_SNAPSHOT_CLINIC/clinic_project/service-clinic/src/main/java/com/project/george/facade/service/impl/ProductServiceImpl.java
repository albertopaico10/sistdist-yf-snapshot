package com.project.george.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;
import com.project.george.facade.service.ProductService;
import com.project.george.util.CommonConstants;
import com.project.george.util.JsonUtils;

@Service
public class ProductServiceImpl implements ProductService {
	
//	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	
	public BeanResponseProduct saveProduct(BeanRequestProduct beanRequestProduct) throws Exception {
		
		String gson=JsonUtils.toJson(beanRequestProduct);
		System.out.println("**** GSON : " + gson);
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseProduct beanResponseProduct=restTemplate.postForObject(CommonConstants.PRODUCT_REST, beanRequestProduct, BeanResponseProduct.class);
		
		return beanResponseProduct;
	}

public boolean verificationExistProduct(String name, int idPresentation)
		throws Exception {
	// TODO Auto-generated method stub
	return false;
}

public BeanResponseListProduct listProductByName(String nameProduct) {
	// TODO Auto-generated method stub
	return null;
}

//public BeanResponseListProduct listProductByName(String nameProduct)
//		throws Exception {
//	// TODO Auto-generated method stub
//	return null;
//}	

/*	public String rucService = CommonConstants.PRODUCT_SOAP;
	
	
	
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
	
	public BeanResponseListProduct listProductByName(String nameProduct){
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseListProduct beanListProduct=new BeanResponseListProduct();
		
		String URL="http://localhost:53924/KardexService.svc/FindProductByName/";
		try {
			BeanResponseCanonicalListProduct listProduct=restTemplate.getForObject(URL+nameProduct, BeanResponseCanonicalListProduct.class);
			System.out.println("Respuesta del servicio : "+listProduct.getListCadenaProduct());
			System.out.println("Respuesta RESULT del servicio : "+listProduct.getResult());
			if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS_LIST.equals(listProduct.getResult())){
				beanListProduct=JsonUtils.jsonToJavaObject(listProduct.getListCadenaProduct(),BeanResponseListProduct.class);
			}
			beanListProduct.setResult(listProduct.getResult());
		} catch (Exception e) {
			beanListProduct.setResult(CommonConstants.ResponseWebService.RESP_WS_CONNECTION_REFUSE);
			System.out.println("Error : "+e.getMessage());
		}
		
		
		
		return beanListProduct;
	}
*/
}
