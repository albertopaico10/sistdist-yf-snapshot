package com.project.george.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the tb_detail_kardex database table.
 * 
 */
@Entity
@Table(name = "tb_detail_kardex")
public class TbDetailKardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private int cantidad;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	private String typeOperation;

	private String comprobante_clase;

	private int comprobante_number;

	private int status;

	private BigDecimal price_Product;

	private BigDecimal price_sale;

	// bi-directional many-to-one association to TbKardex
	// @ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "idKardex")
	private TbKardex tbKardex;

	public TbDetailKardex() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public BigDecimal getPrice_Product() {
		return price_Product;
	}

	public void setPrice_Product(BigDecimal price_Product) {
		this.price_Product = price_Product;
	}

	public BigDecimal getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(BigDecimal price_sale) {
		this.price_sale = price_sale;
	}

	public String getComprobante_clase() {
		return comprobante_clase;
	}

	public void setComprobante_clase(String comprobante_clase) {
		this.comprobante_clase = comprobante_clase;
	}

	public int getComprobante_number() {
		return comprobante_number;
	}

	public void setComprobante_number(int comprobante_number) {
		this.comprobante_number = comprobante_number;
	}

	public TbKardex getTbKardex() {
		return this.tbKardex;
	}

	public void setTbKardex(TbKardex tbKardex) {
		this.tbKardex = tbKardex;
	}

}