package com.project.george.facade.service;

import org.springframework.stereotype.Service;

import com.project.george.bean.product.BeanProduct;
import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;

@Service
public interface ProductService {

	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public boolean verificationExistProduct(String name,int idPresentation)throws Exception;
	
	public BeanResponseListProduct listProductByName(String nameProduct);
}
