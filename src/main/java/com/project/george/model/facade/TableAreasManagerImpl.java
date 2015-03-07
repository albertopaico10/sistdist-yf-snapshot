package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbArea;
import com.project.george.model.TbRole;
import com.project.george.model.dao.TableAreaDao;
import com.project.george.model.dto.TbAreasDTO;


@Service
@Transactional
public class TableAreasManagerImpl implements TableAreasManager{
	
	@Autowired
	TableAreaDao custmTableArea;
	
	public List<TbAreasDTO> listAllAreas() throws Exception {
		System.out.println("Inside listAllAreas");
		List<TbArea> listAllArea=custmTableArea.listAllAreas();
		
		List<TbAreasDTO> newListAllRole=new ArrayList<TbAreasDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for(TbArea beanArea:listAllArea){
			TbAreasDTO beanAreasDTO=new TbAreasDTO();
			beanAreasDTO=utilMethods.copyValuesAreasDTO(beanArea, beanAreasDTO);
			newListAllRole.add(beanAreasDTO);
		}
		return newListAllRole;
	}

	public String addNewArea(TbArea tbAreaBean) throws Exception {
		String returnRsponse=CommonUtil.MantenienceArea.RESPONSE_MANTENIENCE_AREA_NEW;
		try {
			custmTableArea.addNewArea(tbAreaBean);
		} catch (Exception e) {
			returnRsponse=CommonUtil.ERROR;
		}
		return returnRsponse;
	}
	
	public String deleteArea(int idArea) throws Exception {
		String returnRsponse=CommonUtil.MantenienceArea.RESPONSE_MANTENIENCE_AREA_NEW;
		TbArea tbAreaBean=new TbArea();
		tbAreaBean=custmTableArea.beanAreaSpecific(idArea);
		tbAreaBean.setId(idArea);
		tbAreaBean.setStatus(2);//--2 is Inactive
		custmTableArea.deleteArea(tbAreaBean);
		return returnRsponse;
	}
}
