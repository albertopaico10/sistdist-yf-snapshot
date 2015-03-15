package com.project.george.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tb_newpatient database table.
 * 
 */
@Entity
@Table(name="tb_newpatient")
public class TbNewPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String adress;

//	@Temporal(TemporalType.DATE)
	@Column(name="birth_day")
	private Date birthDay;

	@Column(name="code_history_clinic")
	private String codeHistoryClinic;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="date_updated")
	private Timestamp dateUpdated;

	private String districtName;

	private String dni;

	private String lastNamePatient;

	private String namePatient;

	private int statusPatient;

	@Column(name="user_created")
	private int userCreated;

	@Column(name="user_updated")
	private int userUpdated;

	private String sex;
	@Column(name="name_reference")
	private String nameReference;
	@Column(name="phone_reference")
	private String phoneReference;

	public TbNewPatient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCodeHistoryClinic() {
		return this.codeHistoryClinic;
	}

	public void setCodeHistoryClinic(String codeHistoryClinic) {
		this.codeHistoryClinic = codeHistoryClinic;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLastNamePatient() {
		return this.lastNamePatient;
	}

	public void setLastNamePatient(String lastNamePatient) {
		this.lastNamePatient = lastNamePatient;
	}

	public String getNamePatient() {
		return this.namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public int getStatusPatient() {
		return this.statusPatient;
	}

	public void setStatusPatient(int statusPatient) {
		this.statusPatient = statusPatient;
	}

	public int getUserCreated() {
		return this.userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}

	public int getUserUpdated() {
		return this.userUpdated;
	}

	public void setUserUpdated(int userUpdated) {
		this.userUpdated = userUpdated;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
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