package com.project.george.facade.service.impl;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.kardex.BeanRequestKardex;
import com.project.george.bean.catalog.kardex.BeanResponseKardex;
import com.project.george.facade.service.KardexService;

@Service
public class KardexServiceImpl implements KardexService {
	
	
	
	public BeanResponseKardex saveKardex(BeanRequestKardex beanRequestKardex)
			throws Exception {
		RestTemplate restTemplate=new RestTemplate();
		return null;
	}

	
	
	
}
