package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbPresentation;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dto.PresentationDTO;

public interface TablePresentationManager {
	List<PresentationDTO> listAllPresentation() throws Exception;
	String addNewPresentation(TbPresentation tbPresentationBean) throws Exception;
	String deletePresentation(int idPresentation) throws Exception;
	//---------------------
	BeanResponseWeb insertNewPresentation(PresentationDTO beanPresentationDTO)throws Exception;
	BeanResponseWeb listPresentationComplete() throws Exception;
	BeanResponseWeb updatePresentation(PresentationDTO beanPresentationDTO) throws Exception;
	BeanResponseWeb deletePresentationWS(int idPresentation) throws Exception;
}
