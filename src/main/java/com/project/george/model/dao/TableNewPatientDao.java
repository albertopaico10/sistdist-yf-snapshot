package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbNewPatient;

public interface TableNewPatientDao {
	List<TbNewPatient> listAllPatient();
	void addNewPatient(TbNewPatient tbPatientBean);
	void deleteArea(TbNewPatient tbPatientBean);
	TbNewPatient beanNewPatientSpecific(int idPatient);
}
