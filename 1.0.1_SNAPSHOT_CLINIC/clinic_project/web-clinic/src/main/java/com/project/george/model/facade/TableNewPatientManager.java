package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbNewPatient;
import com.project.george.model.dto.TbNewPatientDTO;

public interface TableNewPatientManager {
	String addNewPatient(TbNewPatient tbNewPatientBean)throws Exception;
	List<TbNewPatientDTO> listAllPatient() throws Exception;
	String deletePatient(int idPatient) throws Exception;
}
