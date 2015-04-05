package com.project.george.facade.service;

import org.springframework.stereotype.Service;

import com.project.george.bean.presentation.BeanRequestPresentation;
import com.project.george.bean.presentation.BeanResponseListPresentation;
import com.project.george.bean.presentation.BeanResponsePresentation;

@Service
public interface PresentationService {

	public BeanResponsePresentation savePresentationService(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation listAllPresentation()throws Exception;
	
	public BeanResponsePresentation consultPresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception;
	
	public BeanResponsePresentation updatePresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception;
}
