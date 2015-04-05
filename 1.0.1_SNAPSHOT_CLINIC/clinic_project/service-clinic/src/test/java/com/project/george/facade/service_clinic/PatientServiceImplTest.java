package com.project.george.facade.service_clinic;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.george.bean.paciente.Patient;
import com.project.george.facade.service.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/service-clinic-context.xml")
public class PatientServiceImplTest {
	@Autowired
	public PatientService patientService;
	
	Date date = new Date();
	
	@Test
	public void getPatient(){
		Patient patient = patientService.getPatient(3);
		Assert.assertEquals(new Integer(3), patient.getId());
		Assert.assertEquals("diego5", patient.getNamePatient());
		Assert.assertEquals("diegoff5", patient.getLastNamePatient());
		Assert.assertEquals("66666665", patient.getDni());
		Assert.assertEquals("San Borja", patient.getDistrictName());	
	}
	
	@Test
	public void saveNewPatient(){
		Patient patient = new Patient();
		patient.setId(5);
		patient.setNamePatient("martin");
		patient.setLastNamePatient("savedra");
		patient.setDni("66666669");
		patient.setDistrictName("Los Olivos");
		patient.setBirthDay(new Date());
		patient.setDateCreated(new Timestamp(date.getTime()));
		patient.setDateUpdated(new Timestamp(date.getTime()));
		
		Patient patientSaved = patientService.savePatient(patient);
		Assert.assertEquals("martin", patientSaved.getNamePatient());
		Assert.assertEquals("savedra", patientSaved.getLastNamePatient());
		Assert.assertEquals("66666669", patientSaved.getDni());
		Assert.assertEquals("Los Olivos", patientSaved.getDistrictName());	
	}
	
	@Test
	public void updatePatient(){
		
		Patient patient = new Patient();
		patient.setId(5);
		patient.setNamePatient("don jose");
		patient.setLastNamePatient("de san martin");
		patient.setDni("666666655");
		patient.setBirthDay(new Date());
		patient.setDateCreated(new Timestamp(date.getTime()));
		patient.setDateUpdated(new Timestamp(date.getTime()));
		
		Patient patientUpdated = patientService.updatePatient(patient);
		Assert.assertEquals(new Integer(5), patientUpdated.getId());
		Assert.assertEquals("don jose", patientUpdated.getNamePatient());
		Assert.assertEquals("de san martin", patientUpdated.getLastNamePatient());
		Assert.assertEquals("666666655", patientUpdated.getDni());
	}
	
	@Test
	public void listPatients(){
		List<Patient> patients = patientService.getPatients();
		Assert.assertTrue(patients.size()>0);
	}
	
	@Test@Ignore
	public void removePatient(){
		String response = patientService.removePatient(6);
		Assert.assertEquals("elminado", response);	
	}
	
	
	
}

