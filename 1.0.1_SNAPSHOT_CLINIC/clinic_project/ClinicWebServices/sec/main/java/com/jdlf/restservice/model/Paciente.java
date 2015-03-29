package com.jdlf.restservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="paciente")
@Entity
@Table(name = "tb_newpatient")
public class Paciente {
	
	@XmlElement
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id")
	public Integer id;
	@XmlElement
	@Column(name = "namePatient")
	public String namePatient;
	@XmlElement
	@Column(name = "lastNamePatient")
	public String lastNamePatient;
	@XmlElement
	@Column(name = "dni")
	public String dni;
	@XmlElement
	@Column(name = "birth_day")
	public Date birthDay;
	@XmlElement
	@Column(name = "address")
	public String address;
	@XmlElement
	@Column(name = "districtName")
	public String districtName;	
	@XmlElement
	@Column(name = "statusPatient")
	public Integer statusPatient;
	@XmlElement
	@Column(name = "date_created")
	public Date dateCreated;
	@XmlElement
	@Column(name = "date_updated")
	public Date dateUpdated;
	@XmlElement
	@Column(name = "user_created")
	public Integer userCreated;
	@XmlElement
	@Column(name = "user_updated")
	public Integer userUpdated;
	@XmlElement
	@Column(name = "sex")
	public Integer sex;
	@XmlElement
	@Column(name = "name_reference")
	public String nameReference;
	@XmlElement
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
