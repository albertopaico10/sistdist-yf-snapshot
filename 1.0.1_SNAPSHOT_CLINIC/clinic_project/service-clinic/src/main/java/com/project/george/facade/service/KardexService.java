package com.project.george.facade.service;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.kardex.BeanRequestKardex;
import com.project.george.bean.catalog.kardex.BeanResponseKardex;

@Service
public interface KardexService {
	public BeanResponseKardex saveKardex(BeanRequestKardex beanRequestKardex)throws Exception;
	
	
}
