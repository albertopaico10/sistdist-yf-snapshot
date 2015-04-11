package com.project.george.facade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;
import com.project.george.bean.product.canonical.BeanResponseCanonicalListProduct;
import com.project.george.bean.product.canonical.BeanResponseCanonicalProduct;
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
		
		String gsonResponse=JsonUtils.toJson(beanResponseProduct);
		System.out.println("**** GSON : " + gsonResponse);
		return beanResponseProduct;
	}

	public boolean verificationExistProduct(String name, int idPresentation) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<BeanResponseProduct> listProduct() {
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseCanonicalListProduct listProductAll=restTemplate.getForObject(CommonConstants.PRODUCT_REST_ALL, BeanResponseCanonicalListProduct.class);
		String gsonResponse=JsonUtils.toJson(listProductAll.getListProductObj());
		System.out.println("**** GSON : " + gsonResponse);
		return listProductAll.getListProductObj();
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


	public BeanResponseProduct deleteProduct(BeanRequestProduct beanRequestProduct){
		String gson=JsonUtils.toJson(beanRequestProduct);
		System.out.println("**** GSON : " + gson);
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseProduct beanResponseProduct=restTemplate.postForObject(CommonConstants.PRODUCT_REST_STATUS, beanRequestProduct, BeanResponseProduct.class);
		
		String gsonResponse=JsonUtils.toJson(beanResponseProduct);
		System.out.println("**** GSON : " + gsonResponse);
	
	return beanResponseProduct;
	}

	public BeanResponseProduct updateProduct(BeanRequestProduct beanRequestProduct){
		String gson=JsonUtils.toJson(beanRequestProduct);
		System.out.println("**** GSON : " + gson);
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseProduct beanResponseProduct=restTemplate.postForObject(CommonConstants.PRODUCT_REST_BODY, beanRequestProduct, BeanResponseProduct.class);
		
		String gsonResponse=JsonUtils.toJson(beanResponseProduct);
		System.out.println("**** GSON : " + gsonResponse);
		
	return beanResponseProduct;
	}

}
