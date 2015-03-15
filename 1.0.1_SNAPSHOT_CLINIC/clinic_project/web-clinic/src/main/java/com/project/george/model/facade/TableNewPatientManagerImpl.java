package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbNewPatient;
import com.project.george.model.TbPatient;
import com.project.george.model.TbSystemParam;
import com.project.george.model.dao.TableNewPatientDao;
import com.project.george.model.dto.TbNewPatientDTO;
import com.project.george.model.dto.TbPatientDTO;

@Service
@Transactional
public class TableNewPatientManagerImpl implements TableNewPatientManager {
	
	@Autowired
	TableNewPatientDao custmTableNewPatient;
	@Autowired
	TableSystemParamManager tbSystemMan;

	public String addNewPatient(TbNewPatient tbNewPatientBean) throws Exception {
		String returnRsponse=CommonUtil.MantenienceNewPatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbSystemParam beanSystemParam=null;
		boolean saveSytemParam=false;
		if(tbNewPatientBean.getId()==0){
			saveSytemParam=true;
			beanSystemParam=tbSystemMan.getValueSystemParam(CommonUtil.SystemParam.NAME_PARAM_LAST_CODE);
			tbNewPatientBean.setCodeHistoryClinic(beanSystemParam.getValueParam());
			int intNextCodeHistory=Integer.parseInt(beanSystemParam.getValueParam());
			intNextCodeHistory=intNextCodeHistory+1;
			System.out.println("Ultima codigo de clinica : "+intNextCodeHistory);
			beanSystemParam.setValueParam(String.valueOf(intNextCodeHistory));
		}
		try {
			custmTableNewPatient.addNewPatient(tbNewPatientBean);
			if(saveSytemParam){
				tbSystemMan.updateSystemParam(beanSystemParam);
			}
			
		} catch (Exception e) {
			returnRsponse=CommonUtil.ERROR;
		}
		return returnRsponse;
	}

	public List<TbNewPatientDTO> listAllPatient() throws Exception {
		System.out.println("Inside listAllPatient");
		List<TbNewPatient> listAllPatient=custmTableNewPatient.listAllPatient();
		
		List<TbNewPatientDTO> newListPatient=new ArrayList<TbNewPatientDTO>();
		//--Add Reference Code History
		TbSystemParam beanSystemParam=tbSystemMan.getValueSystemParam(CommonUtil.SystemParam.NAME_PARAM_HISTORY_CLINIC);
		
		UtilMethods utilMethods=new UtilMethods();
		for(TbNewPatient beanPatient:listAllPatient){
			TbNewPatientDTO beanPatientDTO=new TbNewPatientDTO();			
			beanPatientDTO=utilMethods.copyValuesNewPatientDTO(beanPatient, beanPatientDTO);
			beanPatientDTO.setCodeHistoryClinic(beanSystemParam.getValueParam()+beanPatientDTO.getCodeHistoryClinic());
			newListPatient.add(beanPatientDTO);
		}	
		
		return newListPatient;
	}

	public String deletePatient(int idPatient) throws Exception {
		String returnRsponse=CommonUtil.ManteniencePatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbNewPatient tbPatintBean=new TbNewPatient();
		tbPatintBean=custmTableNewPatient.beanNewPatientSpecific(idPatient);
		tbPatintBean.setStatusPatient(2);//--2 is Inactive
		custmTableNewPatient.deleteArea(tbPatintBean);
		return returnRsponse;
	}
	
}
