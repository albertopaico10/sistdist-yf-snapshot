package com.project.george.facade.service.impl;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.facade.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	public BeanProduct saveProduct(BeanRequestProduct beanProduct) {
		
		return null;
	}

	public boolean verificationExistProduct(String name) {
		
		return false;
	}

}
