package com.project.george.facade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.paciente.Patient;

@Service
public interface PatientService {
	
public Patient savePatient(Patient patient);
	
	public Patient updatePatient(Patient patient);
	
	public Patient getPatient(Integer id);
	
	public String removePatient(Integer id);
	
	public List<Patient> getPatients();

}
