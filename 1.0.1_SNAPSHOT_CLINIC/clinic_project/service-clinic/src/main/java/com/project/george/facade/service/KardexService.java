package com.project.george.facade.service;

import org.springframework.stereotype.Service;

import com.project.george.bean.kardex.BeanRequestKardex;
import com.project.george.bean.kardex.BeanResponseKardex;
import com.project.george.bean.kardex.canonical.BeanRequestCanonicalKardex;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalListDetailKardex;

@Service
public interface KardexService {
	public BeanResponseKardex saveKardex(BeanRequestKardex beanRequestKardex)throws Exception;
	
	public BeanResponseKardex listKardexByProduct(String idProduct)throws Exception;
	
	public BeanResponseKardex saveKardexService(BeanRequestCanonicalKardex beanRequestCanonicalKardex)throws Exception;
	
	public BeanResponseCanonicalListDetailKardex listDetailKardex(String idKardex);
}
