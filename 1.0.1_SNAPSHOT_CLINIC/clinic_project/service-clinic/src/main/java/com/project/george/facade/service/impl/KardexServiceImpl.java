package com.project.george.facade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.george.bean.catalog.kardex.BeanRequestKardex;
import com.project.george.bean.catalog.kardex.BeanResponseKardex;
import com.project.george.facade.service.KardexService;
import com.project.george.util.CommonConstants;
import com.project.george.util.JsonUtils;

@Service
public class KardexServiceImpl implements KardexService {
	
//	@Autowired
//	@Qualifier("restTemplate")
//	private RestTemplate restTemplate;
	
	public BeanResponseKardex saveKardex(BeanRequestKardex beanRequestKardex)throws Exception {
		
		String gson=JsonUtils.toJson(beanRequestKardex);
		System.out.println("**** GSON : "+gson);
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseKardex beanResponseKardex=restTemplate.postForObject(CommonConstants.KARDEX_REST, beanRequestKardex, BeanResponseKardex.class);
		
		return beanResponseKardex;
	}
	
	
	
	
	
}
