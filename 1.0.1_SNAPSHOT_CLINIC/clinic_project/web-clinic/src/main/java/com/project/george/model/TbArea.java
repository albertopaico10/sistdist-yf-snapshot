package com.project.george.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_area database table.
 * 
 */
@Entity
@Table(name="tb_area")
public class TbArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String nameArea;

	private int status;

	//bi-directional many-to-one association to TbPatient
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="tbArea")
	private List<TbPatient> tbPatients;

	public TbArea() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameArea() {
		return this.nameArea;
	}

	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TbPatient> getTbPatients() {
		return this.tbPatients;
	}

	public void setTbPatients(List<TbPatient> tbPatients) {
		this.tbPatients = tbPatients;
	}

	public TbPatient addTbPatient(TbPatient tbPatient) {
		getTbPatients().add(tbPatient);
		tbPatient.setTbArea(this);

		return tbPatient;
	}

	public TbPatient removeTbPatient(TbPatient tbPatient) {
		getTbPatients().remove(tbPatient);
		tbPatient.setTbArea(null);

		return tbPatient;
	}

}