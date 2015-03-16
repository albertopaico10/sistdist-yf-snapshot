package com.project.george.facade.business;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;

@Service
public interface ClinicApplicationBusiness {

	public String mensajeTest(String value)throws Exception;
	
	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;

}
