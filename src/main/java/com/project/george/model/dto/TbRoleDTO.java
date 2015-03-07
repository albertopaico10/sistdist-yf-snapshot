package com.project.george.model.dto;

public class TbRoleDTO {

	private int id;
	private String nombreRole;
	private int status;
	private String response;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreRole() {
		return nombreRole;
	}
	public void setNombreRole(String nombreRole) {
		this.nombreRole = nombreRole;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}	
}
