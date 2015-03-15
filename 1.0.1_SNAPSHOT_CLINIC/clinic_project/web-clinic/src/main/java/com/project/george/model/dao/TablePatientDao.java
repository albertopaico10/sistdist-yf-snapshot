package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbArea;
import com.project.george.model.TbPatient;

public interface TablePatientDao {
	
	List<TbPatient> listAllPatient();
	void addNewPatient(TbPatient tbPatientBean);
	List<TbPatient> listAllPatientSpecific(TbPatient tbPatientBean);
	void deleteArea(TbPatient tbPatientBean);
	TbPatient beanPatientSpecific(int idPatient);
}
