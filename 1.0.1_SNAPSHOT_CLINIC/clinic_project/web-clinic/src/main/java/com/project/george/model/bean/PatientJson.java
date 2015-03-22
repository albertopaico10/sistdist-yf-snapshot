package com.project.george.model.bean;

import java.util.List;

import com.project.george.model.dto.TbNewPatientDTO;
import com.project.george.model.dto.TbPatientDTO;
import com.project.george.model.dto.ProductDTO;

public class PatientJson {
	int iTotalRecords;
	int iTotalDisplayRecords;
	String sEcho;
	String sColumns;
//	List<TbPatientDTO> patientData;
	List<TbNewPatientDTO> patientData;
	List<ProductDTO> productData;
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public String getsColumns() {
		return sColumns;
	}
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
	public List<TbNewPatientDTO> getPatientData() {
		return patientData;
	}
	public void setPatientData(List<TbNewPatientDTO> patientData) {
		this.patientData = patientData;
	}
	public List<ProductDTO> getProductData() {
		return productData;
	}
	public void setProductData(List<ProductDTO> productData) {
		this.productData = productData;
	}
}
