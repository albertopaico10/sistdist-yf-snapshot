package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbArea;
import com.project.george.model.TbPresentation;
import com.project.george.model.dao.TablePresentationDao;
import com.project.george.model.dto.TbPresentationDTO;

@Service
@Transactional
public class TablePresentationManagerImpl implements TablePresentationManager {

	@Autowired
	TablePresentationDao custmTablePresentation;
	
	
	public List<TbPresentationDTO> listAllPresentation() throws Exception {
		System.out.println("Inside listAllPresentation");
		List<TbPresentation> listAllPresentation=custmTablePresentation.listAllPresentation();
		
		List<TbPresentationDTO> newListAllPresentation=new ArrayList<TbPresentationDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for (TbPresentation beanPresentation:listAllPresentation) {
			 TbPresentationDTO beanPresentationDTO=new TbPresentationDTO();
			 beanPresentationDTO=utilMethods.copyValuesPresentationDTO(beanPresentation, beanPresentationDTO);
			 newListAllPresentation.add(beanPresentationDTO);
		}
		if(newListAllPresentation.size()==0){
			newListAllPresentation=null;
		}
		return newListAllPresentation;
	}
	
	public String addNewPresentation(TbPresentation tbPresentationBean) throws Exception {
		String returnRsponse=CommonUtil.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTATION_NEW;
		try {
			custmTablePresentation.addNewPresentation(tbPresentationBean);
		} catch (Exception e) {
			returnRsponse=CommonUtil.ERROR;
		}
		return returnRsponse;
	}
	
	public String deletePresentation(int idPresentation) throws Exception {
		String returnRsponse=CommonUtil.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTATION_NEW;
		TbPresentation tbPresentationBean=new TbPresentation();
		tbPresentationBean=custmTablePresentation.beanPresentationSpecific(idPresentation);
		tbPresentationBean.setId(idPresentation);
		tbPresentationBean.setStatus(2);//--2 is Inactive
		custmTablePresentation.deletePresentation(tbPresentationBean);
		return returnRsponse;
	}

}
