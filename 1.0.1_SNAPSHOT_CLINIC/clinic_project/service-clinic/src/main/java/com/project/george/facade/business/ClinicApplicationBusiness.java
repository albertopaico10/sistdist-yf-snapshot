package com.project.george.facade.business;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponseListPresentation;
import com.project.george.bean.catalog.presentation.BeanResponsePresentation;
import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;

@Service
public interface ClinicApplicationBusiness {

	public String mensajeTest(String value)throws Exception;
	
	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception;
	
	public BeanResponseListPresentation savePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation listAllPresentation()throws Exception;
	
	public BeanResponseListPresentation updatePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation deletePresentation(BeanRequestPresentation beanRequestPresentation)throws Exception;
}
