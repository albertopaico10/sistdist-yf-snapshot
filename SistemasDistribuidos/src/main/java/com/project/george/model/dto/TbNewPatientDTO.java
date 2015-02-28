package com.project.george.model.dto;

import java.util.Date;

public class TbNewPatientDTO {

	
	public int id;
	public String address;
	public Date birthDay;
	public String birthDayFormat;
	public String codeHistoryClinic;
	public String districtName;
	public String dni;
	public String lastNamePatient;
	public String namePatient;
	public String completeName;
	public String idSexo;
	public String sexoValue;
	public String nameReference;
	public String phoneReference;
	
	public int edad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getCodeHistoryClinic() {
		return codeHistoryClinic;
	}
	public void setCodeHistoryClinic(String codeHistoryClinic) {
		this.codeHistoryClinic = codeHistoryClinic;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getLastNamePatient() {
		return lastNamePatient;
	}
	public void setLastNamePatient(String lastNamePatient) {
		this.lastNamePatient = lastNamePatient;
	}
	public String getNamePatient() {
		return namePatient;
	}
	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getBirthDayFormat() {
		return birthDayFormat;
	}
	public void setBirthDayFormat(String birthDayFormat) {
		this.birthDayFormat = birthDayFormat;
	}
	public String getIdSexo() {
		return idSexo;
	}
	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}
	
	public String getNameReference() {
		return nameReference;
	}
	public void setNameReference(String nameReference) {
		this.nameReference = nameReference;
	}
	public String getPhoneReference() {
		return phoneReference;
	}
	public void setPhoneReference(String phoneReference) {
		this.phoneReference = phoneReference;
	}
	public String getSexoValue() {
		return sexoValue;
	}
	public void setSexoValue(String sexoValue) {
		this.sexoValue = sexoValue;
	}
}
