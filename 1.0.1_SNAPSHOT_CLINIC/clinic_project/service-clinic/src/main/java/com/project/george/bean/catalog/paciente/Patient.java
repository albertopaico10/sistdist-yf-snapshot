package com.project.george.bean.catalog.paciente;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType
@XmlRootElement(name="paciente")
public class Patient {
	
	@XmlElement
	public Integer id;
	@XmlElement
	public String namePatient;
	@XmlElement
	public String lastNamePatient;
	@XmlElement
	public String dni;
	@XmlElement
	public Date birthDay;
	@XmlElement
	public String address;
	@XmlElement
	public String districtName;
	@XmlElement
	public Integer statusPatient;
	@XmlElement
	public Date dateCreated;
	@XmlElement
	public Date dateUpdated;
	@XmlElement
	public Integer userCreated;
	@XmlElement
	public Integer userUpdated;
	@XmlElement
	public Integer sex;
	@XmlElement
	public String nameReference;
	@XmlElement
	public String phoneReference;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getStatusPatient() {
		return statusPatient;
	}
	public void setStatusPatient(Integer statusPatient) {
		this.statusPatient = statusPatient;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public Integer getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(Integer userCreated) {
		this.userCreated = userCreated;
	}
	public Integer getUserUpdated() {
		return userUpdated;
	}
	public void setUserUpdated(Integer userUpdated) {
		this.userUpdated = userUpdated;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
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

}
