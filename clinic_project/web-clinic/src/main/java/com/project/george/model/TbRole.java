package com.project.george.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_role database table.
 * 
 */
@Entity
@Table(name="tb_role")
public class TbRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombreRole;

	private int status;
	//bi-directional many-to-one association to TbUser
	@OneToMany(mappedBy="tbRole")
	private List<TbUser> tbUsers;

	public TbRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRole() {
		return this.nombreRole;
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

	public List<TbUser> getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(List<TbUser> tbUsers) {
		this.tbUsers = tbUsers;
	}
}