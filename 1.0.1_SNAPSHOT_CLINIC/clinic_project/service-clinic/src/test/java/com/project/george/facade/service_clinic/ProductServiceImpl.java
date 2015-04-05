package com.project.george.facade.service_clinic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.george.bean.product.BeanRequestProduct;
import com.project.george.bean.product.BeanResponseListProduct;
import com.project.george.bean.product.BeanResponseProduct;
import com.project.george.facade.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/service-clinic-context.xml")
public class ProductServiceImpl {
	@Autowired
	public ProductService productService;

	@Test
	public void testSaveProduct()throws Exception{
		System.out.println("Dentro del test");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse("2015-07-16");
		
		BeanRequestProduct beanRequest=new BeanRequestProduct();
		beanRequest.setNameProduct("jojojojojojo");
		beanRequest.setStatus(1);
		beanRequest.setIdPresentation(4);
		beanRequest.setPrice(new BigDecimal(3));
		beanRequest.setPriceSale(new BigDecimal(5));
		beanRequest.setExpirationDate("2015-03-05");
		productService.saveProduct(beanRequest);
	}
	
	@Test
	public void testValidateProduct()throws Exception{
		BeanRequestProduct beanRequest=new BeanRequestProduct();
		beanRequest.setNameProduct("Test Producto");
		beanRequest.setStatus(1);
		productService.verificationExistProduct(beanRequest.getNameProduct(), beanRequest.getIdPresentation());
	}
	
	@Test
	public void testListProduct()throws Exception{
		BeanResponseListProduct beanResponse=new BeanResponseListProduct();
//		beanResponse=productService.listProductByName("producto");
		List<BeanResponseProduct> listProd=productService.listProduct();
		System.out.println("Cantidad :"+listProd.size());
	}
}
