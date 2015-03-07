package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbPatient;
import com.project.george.model.dto.TbPatientDTO;

public interface TablePatientManager {
	
	String addNewPatient(TbPatient tbPatientBean)throws Exception;
	List<TbPatientDTO> listAllPatient() throws Exception;
	List<TbPatientDTO> listAllPatientSpecific(TbPatient tbPatientBean) throws Exception;
	String deletePatient(int idPatient) throws Exception;

}
