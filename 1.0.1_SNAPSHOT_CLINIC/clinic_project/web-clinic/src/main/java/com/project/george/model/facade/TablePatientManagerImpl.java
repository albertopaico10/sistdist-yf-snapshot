package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonConstants;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbPatient;
import com.project.george.model.TbSystemParam;
import com.project.george.model.dao.TablePatientDao;
import com.project.george.model.dao.TableSystemParamDao;
import com.project.george.model.dto.TbPatientDTO;

@Service
@Transactional
public class TablePatientManagerImpl implements TablePatientManager {
	
	@Autowired
	TablePatientDao custmTablePatient;
	
	@Autowired
	TableSystemParamDao custmTableSystemParam;
	
	@Autowired
	TableSystemParamManager tbSystemMan;

	public String addNewPatient(TbPatient tbPatientBean) throws Exception {
		String returnRsponse=CommonConstants.ManteniencePatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbSystemParam beanSystemParam=null;
		boolean saveSytemParam=false;
		if(!saveSytemParam){
			saveSytemParam=true;
			beanSystemParam=tbSystemMan.getValueSystemParam(CommonConstants.SystemParam.NAME_PARAM_LAST_CODE);
			tbPatientBean.setHistoryClinic(beanSystemParam.getValueParam());
			int intNextCodeHistory=Integer.parseInt(beanSystemParam.getValueParam());
			intNextCodeHistory=intNextCodeHistory+1;
			System.out.println("Ultima codigo de clinica : "+intNextCodeHistory);
			beanSystemParam.setValueParam(String.valueOf(intNextCodeHistory));
		}		
		try {
			custmTablePatient.addNewPatient(tbPatientBean);
			if(saveSytemParam){
				custmTableSystemParam.updateSystemParam(beanSystemParam);
			}
			
		} catch (Exception e) {
			returnRsponse=CommonConstants.ERROR;
		}
		return returnRsponse;
	}
	
	public List<TbPatientDTO> listAllPatient() throws Exception {
		System.out.println("Inside listAllPatient");
		List<TbPatient> listAllPatient=custmTablePatient.listAllPatient();
		
		List<TbPatientDTO> newListPatient=new ArrayList<TbPatientDTO>();
		//--Add Reference Code History
		TbSystemParam beanSystemParam=tbSystemMan.getValueSystemParam(CommonConstants.SystemParam.NAME_PARAM_HISTORY_CLINIC);
		
		UtilMethods utilMethods=new UtilMethods();
		for(TbPatient beanPatient:listAllPatient){
			System.out.println("Values : "+beanPatient.getTbArea().getNameArea()+"**"+beanPatient.getNamePatient());
			TbPatientDTO beanPatientDTO=new TbPatientDTO();			
			beanPatientDTO=utilMethods.copyValuesPatientDTO(beanPatient, beanPatientDTO);
			beanPatientDTO.setHistoryClinic(beanSystemParam.getValueParam()+beanPatientDTO.getHistoryClinic());
			newListPatient.add(beanPatientDTO);
		}	
		
		return newListPatient;
	}
	
	
	public List<TbPatientDTO> listAllPatientSpecific(TbPatient tbPatientBean) throws Exception {
		System.out.println("Inside listAllPatientSpecific");
		List<TbPatient> listAllPatient=custmTablePatient.listAllPatientSpecific(tbPatientBean);
		
		List<TbPatientDTO> newListPatient=new ArrayList<TbPatientDTO>();
		//--Add Reference Code History
		TbSystemParam beanSystemParam=tbSystemMan.getValueSystemParam(CommonConstants.SystemParam.NAME_PARAM_HISTORY_CLINIC);
		
		UtilMethods utilMethods=new UtilMethods();
		for(TbPatient beanPatient:listAllPatient){
			System.out.println("Values : "+beanPatient.getTbArea().getNameArea()+"**"+beanPatient.getNamePatient());
			TbPatientDTO beanPatientDTO=new TbPatientDTO();
			beanPatientDTO=utilMethods.copyValuesPatientDTO(beanPatient, beanPatientDTO);
			beanPatientDTO.setHistoryClinic(beanSystemParam.getValueParam()+beanPatientDTO.getHistoryClinic());
			newListPatient.add(beanPatientDTO);
		}	
		
		return newListPatient;
	}

	public String deletePatient(int idPatient) throws Exception {
		String returnRsponse=CommonConstants.ManteniencePatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbPatient tbPatintBean=new TbPatient();
		tbPatintBean=custmTablePatient.beanPatientSpecific(idPatient);
		tbPatintBean.setStatusPatient(2);//--2 is Inactive
		custmTablePatient.deleteArea(tbPatintBean);
		return returnRsponse;
	}

}
