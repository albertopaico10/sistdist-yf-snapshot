package com.project.george.model.dto;

import java.util.Date;

public class TbPatientDTO {
	
	public int id;
	public String namePatient;
	public String lastNamePatient;
	public String completeName;
	public String dni;
	public String adress;
	public String districtName;
	public Date birthDay;
	public String birthDayFormat;
	public int edad;
	public int idArea;
	public String nameAra;
	public String historyClinic;
//	public TbA
	public int statusPatient;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePatient() {
		return namePatient;
	}
	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}
	public String getLastNamePatient() {
		return lastNamePatient;
	}
	public void setLastNamePatient(String lastNamePatient) {
		this.lastNamePatient = lastNamePatient;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	public String getNameAra() {
		return nameAra;
	}
	public void setNameAra(String nameAra) {
		this.nameAra = nameAra;
	}
	public int getStatusPatient() {
		return statusPatient;
	}
	public void setStatusPatient(int statusPatient) {
		this.statusPatient = statusPatient;
	}
	public String getBirthDayFormat() {
		return birthDayFormat;
	}
	public void setBirthDayFormat(String birthDayFormat) {
		this.birthDayFormat = birthDayFormat;
	}
	public String getHistoryClinic() {
		return historyClinic;
	}
	public void setHistoryClinic(String historyClinic) {
		this.historyClinic = historyClinic;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
}
