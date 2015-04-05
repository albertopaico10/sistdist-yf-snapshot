package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.bean.paciente.Patient;
import com.project.george.common.CommonConstants;
import com.project.george.common.UtilMethods;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.model.TbNewPatient;
import com.project.george.model.TbSystemParam;
import com.project.george.model.dao.TableNewPatientDao;
import com.project.george.model.dto.TbNewPatientDTO;

@Service
@Transactional
public class TableNewPatientManagerImpl implements TableNewPatientManager {
	
	@Autowired
	TableNewPatientDao custmTableNewPatient;
	@Autowired
	TableSystemParamManager tbSystemMan;
	@Autowired
	public ClinicApplicationBusiness clinicApplicationBusiness;

	public String addNewPatient(TbNewPatient tbNewPatientBean) throws Exception {
		String returnRsponse=CommonConstants.MantenienceNewPatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbSystemParam beanSystemParam=null;
		boolean saveSytemParam=false;
		if(tbNewPatientBean.getId()==0){
			saveSytemParam=true;
			beanSystemParam=tbSystemMan.getValueSystemParam(CommonConstants.SystemParam.NAME_PARAM_LAST_CODE);
			tbNewPatientBean.setCodeHistoryClinic(beanSystemParam.getValueParam());
			int intNextCodeHistory=Integer.parseInt(beanSystemParam.getValueParam());
			intNextCodeHistory=intNextCodeHistory+1;
			System.out.println("Ultima codigo de clinica : "+intNextCodeHistory);
			beanSystemParam.setValueParam(String.valueOf(intNextCodeHistory));
		}
		try {
			
			Patient tbPatient = new Patient();
			tbPatient.setId(tbNewPatientBean.getId());
			tbPatient.setAddress(tbNewPatientBean.getAdress());
			tbPatient.setBirthDay(tbNewPatientBean.getBirthDay());
			tbPatient.setDateCreated(tbNewPatientBean.getDateCreated());
			tbPatient.setDateUpdated(tbNewPatientBean.getDateUpdated());
			tbPatient.setDistrictName(tbNewPatientBean.getDistrictName());
			tbPatient.setDni(tbNewPatientBean.getDni());
			tbPatient.setLastNamePatient(tbNewPatientBean.getLastNamePatient());
			tbPatient.setNamePatient(tbNewPatientBean.getNamePatient());
			tbPatient.setStatusPatient(tbNewPatientBean.getStatusPatient());
			tbPatient.setUserCreated(tbNewPatientBean.getUserCreated());
			tbPatient.setUserUpdated(tbNewPatientBean.getUserUpdated());
			
			if(tbNewPatientBean.getId()==0){
				//custmTableNewPatient.addNewPatient(tbNewPatientBean);
				tbPatient = clinicApplicationBusiness.savePatient(tbPatient);
			} else {
				tbPatient = clinicApplicationBusiness.updatePatient(tbPatient);
			}
			
			
			if(saveSytemParam){
				tbSystemMan.updateSystemParam(beanSystemParam);
			}
			
		} catch (Exception e) {
			returnRsponse=CommonConstants.ERROR;
		}
		return returnRsponse;
	}

	public List<TbNewPatientDTO> listAllPatient() throws Exception {
		System.out.println("Inside listAllPatient");
		//List<TbNewPatient> listAllPatient=custmTableNewPatient.listAllPatient();
		
		List<TbNewPatient> listAllPatient = new ArrayList<TbNewPatient>();
		List<Patient> patients = clinicApplicationBusiness.getPatients();
		
		Date date = new Date();//TODO: to refactor
		List<TbNewPatientDTO> newListPatient=new ArrayList<TbNewPatientDTO>();
		try {
			for (Patient patient : patients) {
				TbNewPatient tbPatient = new TbNewPatient();
				tbPatient.setId(patient.getId());
				tbPatient.setAdress(patient.getAddress());
				tbPatient.setBirthDay(patient.getBirthDay());
				tbPatient.setDateCreated(patient.getDateCreated());
				tbPatient.setDateUpdated(patient.getDateUpdated());
				tbPatient.setDistrictName(patient.getDistrictName());
				tbPatient.setDni(patient.getDni());
				tbPatient.setLastNamePatient(patient.getLastNamePatient());
				tbPatient.setNamePatient(patient.getNamePatient());
				
				if(patient.getStatusPatient()!=null)
					tbPatient.setStatusPatient(patient.getStatusPatient());
				
				if(patient.getUserCreated()!=null)
					tbPatient.setUserCreated(patient.getUserCreated());
				
				if(patient.getUserUpdated()!=null)
					tbPatient.setUserUpdated(patient.getUserUpdated());
				
				listAllPatient.add(tbPatient);
				
			}
			
			
			//--Add Reference Code History
			TbSystemParam beanSystemParam=tbSystemMan.getValueSystemParam(CommonConstants.SystemParam.NAME_PARAM_HISTORY_CLINIC);
			
			UtilMethods utilMethods=new UtilMethods();
			for(TbNewPatient beanPatient:listAllPatient){
				TbNewPatientDTO beanPatientDTO=new TbNewPatientDTO();			
				beanPatientDTO=utilMethods.copyValuesNewPatientDTO(beanPatient, beanPatientDTO);
				beanPatientDTO.setCodeHistoryClinic(beanSystemParam.getValueParam()+beanPatientDTO.getCodeHistoryClinic());
				newListPatient.add(beanPatientDTO);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		
		
		return newListPatient;
	}

	public String deletePatient(int idPatient) throws Exception {
		String returnRsponse=CommonConstants.ManteniencePatient.RESPONSE_MANTENIENCE_PATIENT_NEW;
		TbNewPatient tbPatintBean=new TbNewPatient();
		tbPatintBean=custmTableNewPatient.beanNewPatientSpecific(idPatient);
		tbPatintBean.setStatusPatient(2);//--2 is Inactive
		//custmTableNewPatient.deleteArea(tbPatintBean);
		
		Patient tbPatient = new Patient();
		tbPatient.setId(tbPatintBean.getId());
		tbPatient.setAddress(tbPatintBean.getAdress());
		tbPatient.setBirthDay(tbPatintBean.getBirthDay());
		tbPatient.setDateCreated(tbPatintBean.getDateCreated());
		tbPatient.setDateUpdated(tbPatintBean.getDateUpdated());
		tbPatient.setDistrictName(tbPatintBean.getDistrictName());
		tbPatient.setDni(tbPatintBean.getDni());
		tbPatient.setLastNamePatient(tbPatintBean.getLastNamePatient());
		tbPatient.setNamePatient(tbPatintBean.getNamePatient());
		
		//if(tbPatintBean.getStatusPatient()!=null)
			tbPatient.setStatusPatient(tbPatintBean.getStatusPatient());
		
		//if(tbPatintBean.getUserCreated()!=null)
			tbPatient.setUserCreated(tbPatintBean.getUserCreated());
		
		//if(tbPatintBean.getUserUpdated()!=null)
			tbPatient.setUserUpdated(tbPatintBean.getUserUpdated());
		
		clinicApplicationBusiness.updatePatient(tbPatient);
		return returnRsponse;
	}
	
}
