package com.project.george.facade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.george.bean.kardex.BeanRequestKardex;
import com.project.george.bean.kardex.BeanResponseKardex;
import com.project.george.bean.kardex.canonical.BeanRequestCanonicalKardex;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalKardex;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalKardexDetail;
import com.project.george.bean.kardex.canonical.BeanResponseCanonicalListDetailKardex;
import com.project.george.facade.service.KardexService;
import com.project.george.util.CommonConstants;
import com.project.george.util.JsonUtils;

@Service
public class KardexServiceImpl implements KardexService {
	
	public BeanResponseKardex saveKardex(BeanRequestKardex beanRequestKardex)throws Exception {
		
		String gson=JsonUtils.toJson(beanRequestKardex);
		System.out.println("**** GSON : "+gson);
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseKardex beanResponseKardex=restTemplate.postForObject(CommonConstants.KARDEX_REST, beanRequestKardex, BeanResponseKardex.class);
		
		return beanResponseKardex;
	}
	
	public BeanResponseKardex listKardexByProduct(String idProduct)throws Exception{
		System.out.println(CommonConstants.Logger.LOGGER_START);
		BeanResponseKardex beanResponseKardex=new BeanResponseKardex();
		RestTemplate restTemplate=new RestTemplate();
		String URL="http://localhost:53924/KardexService.svc/GetKardex/"+idProduct;
		System.out.println("URL : "+URL);
		BeanResponseCanonicalKardex beanResponseCanonicalKardex=restTemplate.getForObject(URL, BeanResponseCanonicalKardex.class);
		String gsonResp=JsonUtils.toJson(beanResponseCanonicalKardex);
		System.out.println("RESPONSE : "+gsonResp);
		if(CommonConstants.ResponseWebService.RESP_WS_EXIST.equals(beanResponseCanonicalKardex.getResult())){
//			beanResponseKardex.setIdProduct(Integer.parseInt(idProduct));
			beanResponseKardex.setId(beanResponseCanonicalKardex.getId());
			beanResponseKardex.setNameProduct(beanResponseCanonicalKardex.getNameProduct());
			beanResponseKardex.setNamePresentation(beanResponseCanonicalKardex.getNamePresentation());
			beanResponseKardex.setTotalProductEntry(beanResponseCanonicalKardex.getTotalProductEntry());
			beanResponseKardex.setTotalProductEgress(beanResponseCanonicalKardex.getTotalProductEgress());
			beanResponseKardex.setCountProduct(beanResponseCanonicalKardex.getCountProduct());
			beanResponseKardex.setPriceTotalProduct(beanResponseCanonicalKardex.getPriceTotalProduct());
			beanResponseKardex.setPriceTotalSale(beanResponseCanonicalKardex.getPriceTotalSale());
			beanResponseKardex.setMessages(beanResponseCanonicalKardex.getMessages());
		}
		beanResponseKardex.setResult(beanResponseCanonicalKardex.getResult());
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanResponseKardex;
	}
	
	public BeanResponseKardex saveKardexService(BeanRequestCanonicalKardex beanRequestCanonicalKardex)throws Exception{
		System.out.println(CommonConstants.Logger.LOGGER_START+"** saveKardexService");
		BeanResponseKardex beanResponseKardex=new BeanResponseKardex();
		
		String gson=JsonUtils.toJson(beanRequestCanonicalKardex);
		System.out.println("**** GSON : "+gson);
		
		String URL="http://localhost:53924/KardexService.svc/SaveKardex";
		
		RestTemplate restTemplate=new RestTemplate();
		BeanResponseCanonicalKardex beanResponseCanonicalKardex=restTemplate.postForObject(URL, beanRequestCanonicalKardex, BeanResponseCanonicalKardex.class);
		String gsonResp=JsonUtils.toJson(beanResponseCanonicalKardex);
		System.out.println("RESPONSE : "+gsonResp);
		if(CommonConstants.ResponseWebService.RESP_WS_SUCCESS.equals(beanResponseCanonicalKardex.getResult())){
			if(beanResponseCanonicalKardex.getMessages()!=null&&CommonConstants.ResponseWebService.RESP_WS_MESSAGES_INSUFFICIENT_PRODUCT.equals(beanResponseCanonicalKardex.getMessages())){
				beanResponseKardex.setMessages(CommonConstants.ResponseWebService.RESP_WS_MESSAGES_INSUFFICIENT_PRODUCT);
			}
			beanResponseKardex.setResult(CommonConstants.ResponseWebService.RESP_WS_SUCCESS_SAVE);
			
		}else{
			beanResponseKardex.setResult(CommonConstants.ResponseWebService.RESP_WS_ERROR);
		}
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanResponseKardex;
	}
	
	public BeanResponseCanonicalListDetailKardex listDetailKardex(String idKardex){
		System.out.println(CommonConstants.Logger.LOGGER_START+"*** listDetailKardex");
		RestTemplate restTemplate=new RestTemplate();
		String URL="http://localhost:53924/KardexService.svc/GetDetailKardex/"+idKardex;
		System.out.println("**"+URL);
		BeanResponseCanonicalListDetailKardex beanListKardexDetail=restTemplate.getForObject(URL, BeanResponseCanonicalListDetailKardex.class);
		String gson=JsonUtils.toJson(beanListKardexDetail);
		System.out.println("RESPONSE : "+gson);
		System.out.println(CommonConstants.Logger.LOGGER_END);
		return beanListKardexDetail;  
	}
	
}
