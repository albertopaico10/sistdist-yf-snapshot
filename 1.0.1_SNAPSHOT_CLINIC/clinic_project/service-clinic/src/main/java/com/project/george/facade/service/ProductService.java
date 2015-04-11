package com.project.george.facade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;
import com.project.george.bean.product.canonical.BeanResponseCanonicalListProduct;

@Service
public interface ProductService {

	public BeanResponseProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseProduct deleteProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseProduct updateProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public boolean verificationExistProduct(String name,int idPresentation)throws Exception;
	
	public BeanResponseCanonicalListProduct listProduct();
	
	public BeanResponseListProduct listProductByName(String nameProduct);
}
