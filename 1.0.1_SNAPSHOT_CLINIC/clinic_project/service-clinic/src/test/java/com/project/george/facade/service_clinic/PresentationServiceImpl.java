package com.project.george.facade.service_clinic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponsePresentation;
import com.project.george.facade.service.PresentationService;
import com.project.george.util.CommonConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/service-clinic-context.xml")
public class PresentationServiceImpl {
	@Autowired
	public PresentationService presentationService;
	@Test
	public void testSavePresentation()throws Exception{
		BeanRequestPresentation request=new BeanRequestPresentation();
		request.setNamePresentation("Dios mio2222...!! Gracias");
		BeanResponsePresentation response=presentationService.savePresentationService(request);
		System.out.println("Response : "+response.getResult());
		Assert.assertEquals(response.getResult(), CommonConstants.ResponseWebLayer.RESP_SL_ERROR);
	}
	
	@Test
	public void testListPresentation()throws Exception{
		System.out.println("ENTREEEEEEEEEEEEEEEEEEEE");
		presentationService.listAllPresentation();
	}
	
	@Test
	public void testConsultarPresentatcion()throws Exception{
		System.out.println("ENTREEEEEEEEEEEEEEEEEEEE");
		BeanRequestPresentation request=new BeanRequestPresentation();
		request.setId(12);
		BeanResponsePresentation response=presentationService.consultPresentationService(request);
	}
	
	@Test
	public void testUpdatePresentation()throws Exception{
		BeanRequestPresentation request=new BeanRequestPresentation();
		request.setNamePresentation("termometro jejejeje");
		request.setStatus(1);
		request.setDateCreated("2015-09-11");
		request.setId(54);
		BeanResponsePresentation response=presentationService.updatePresentationService(request);
		System.out.println("Response : "+response.getResult());
		Assert.assertEquals(response.getResult(), CommonConstants.ResponseWebLayer.RESP_SL_ERROR);
	}
}
