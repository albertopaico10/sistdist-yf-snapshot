package com.project.george.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UtilMethodsTest {

	@Test
	public void testStringPassword()throws Exception{
		UtilMethods util=new UtilMethods();
		String valor=util.getStringMessageDigest("holaaaaa","MD5");
		System.out.println("Valor final "+valor);
	}
	@Test
	public void testObtainEdad()throws Exception{
		UtilMethods util=new UtilMethods();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "12/10/2014";
		
		Date fecha=formatter.parse(dateInString);
		System.out.println("Valor fecha : "+fecha);
		int valor=util.obtainEdad(fecha);
		System.out.println("Años "+valor);
	}
	
	@Test
	public void testConverFormat()throws Exception{
		UtilMethods util=new UtilMethods();
		String format=util.convertDateFormat("04/30/2015");
		System.out.println("Response : form"+format);
	}
	
	
}
