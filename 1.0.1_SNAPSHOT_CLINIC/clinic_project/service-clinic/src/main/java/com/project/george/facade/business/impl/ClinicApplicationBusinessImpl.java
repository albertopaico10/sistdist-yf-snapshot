package com.project.george.facade.business.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.facade.service.ProductService;
import com.project.george.util.CommonConstants;

@Service
public class ClinicApplicationBusinessImpl implements ClinicApplicationBusiness {
	public Logger logger=Logger.getLogger(ClinicApplicationBusinessImpl.class);
	@Autowired
	public ProductService productService;
	
	public String mensajeTest(String value) throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		return "HOLA .... "+value;
	}

	public BeanProduct saveProduct(BeanRequestProduct beanProduct)throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		//--Validate if Exist Producto with same Presentation
		boolean validationProduct=productService.verificationExistProduct(beanProduct.getNameProduct());
		//--End
		if(!validationProduct){
			//--Save Product
			BeanProduct responseProduct=productService.saveProduct(beanProduct);
		}		
		//--List All Product with status "Active"
		
		
		logger.info(CommonConstants.Logger.LOGGER_END);
		return null;
	}

}
