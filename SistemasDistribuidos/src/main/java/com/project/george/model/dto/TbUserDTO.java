package com.project.george.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TbUserDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String apellidoUsuario;
	private Timestamp dateCreated;
	private Timestamp dateUpdated;
	private String nombreUsuario;
	private String password;
	private int userCreated;
	private Date lastLoginUpdated;
	private String lastLoginFormat;
	private int userUpdated;
	private String userName;
	private String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
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
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
	}
	public int getUserUpdated() {
		return userUpdated;
	}
	public void setUserUpdated(int userUpdated) {
		this.userUpdated = userUpdated;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getLastLoginUpdated() {
		return lastLoginUpdated;
	}
	public void setLastLoginUpdated(Date lastLoginUpdated) {
		this.lastLoginUpdated = lastLoginUpdated;
	}
	public String getLastLoginFormat() {
		return lastLoginFormat;
	}
	public void setLastLoginFormat(String lastLoginFormat) {
		this.lastLoginFormat = lastLoginFormat;
	}
	
}
