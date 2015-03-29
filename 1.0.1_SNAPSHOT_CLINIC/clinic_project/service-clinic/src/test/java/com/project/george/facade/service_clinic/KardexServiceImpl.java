package com.project.george.facade.service_clinic;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.george.bean.catalog.kardex.BeanRequestKardex;
import com.project.george.bean.catalog.kardex.BeanResponseKardex;
import com.project.george.facade.service.KardexService;

@ContextConfiguration(locations = {"/service-clinic-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class KardexServiceImpl {
	@Autowired
	public KardexService kardexService;
	@Test
	public void testSaveKardex()throws Exception{
		BeanRequestKardex beanRequestKardex=new BeanRequestKardex();
		beanRequestKardex.setIdProduct(123);
		beanRequestKardex.setPriceProductKardex(new BigDecimal(20));
		beanRequestKardex.setCountProduct(10);
		beanRequestKardex.setStatus(1);
		beanRequestKardex.setTotalProductEntry(50);
		beanRequestKardex.setTotalProductEgress(40);
		beanRequestKardex.setDescription("TestDescription");
		beanRequestKardex.setPriceTotalProduct(new BigDecimal(300));
		beanRequestKardex.setPriceTotalSale(new BigDecimal(400));
		
		BeanResponseKardex response=kardexService.saveKardex(beanRequestKardex);
		System.out.println("Response : "+response.getResult());
		
	}
	
	@Test
	public void testSaveDetailKardex()throws Exception{
		BeanRequestKardex beanRequestKardex=new BeanRequestKardex();
	}
	
}


