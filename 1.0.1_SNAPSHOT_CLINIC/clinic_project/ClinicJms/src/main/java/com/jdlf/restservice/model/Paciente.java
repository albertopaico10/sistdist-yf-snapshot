package com.jdlf.restservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tb_newpatient")
public class Paciente implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id")
	public Integer id;
	@Column(name = "namePatient")
	public String namePatient;
	@Column(name = "lastNamePatient")
	public String lastNamePatient;
	@Column(name = "dni")
	public String dni;
	@Column(name = "birth_day")
	public Date birthDay;
	@Column(name = "address")
	public String address;
	@Column(name = "districtName")
	public String districtName;	
	@Column(name = "statusPatient")
	public Integer statusPatient;
	@Column(name = "date_created")
	public Timestamp dateCreated;
	@Column(name = "date_updated")
	public Timestamp dateUpdated;
	@Column(name = "user_created")
	public Integer userCreated;
	@Column(name = "user_updated")
	public Integer userUpdated;
	@Column(name = "sex")
	public Integer sex;
	@Column(name = "name_reference")
	public String nameReference;
	@Column(name = "phone_reference")
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
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Timestamp getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Timestamp dateUpdated) {
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
