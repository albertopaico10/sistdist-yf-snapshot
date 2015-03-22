package com.project.george.facade.service;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponseListPresentation;
import com.project.george.bean.catalog.presentation.BeanResponsePresentation;

@Service
public interface PresentationService {

	public BeanResponsePresentation savePresentationService(BeanRequestPresentation beanRequestPresentation)throws Exception;
	
	public BeanResponseListPresentation listAllPresentation()throws Exception;
	
	public BeanResponsePresentation consultPresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception;
	
	public BeanResponsePresentation updatePresentationService(BeanRequestPresentation beanRequestPresentation) throws Exception;
}
