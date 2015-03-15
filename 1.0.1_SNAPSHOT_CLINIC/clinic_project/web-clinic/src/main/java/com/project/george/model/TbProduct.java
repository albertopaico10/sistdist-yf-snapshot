package com.project.george.model;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the tb_product database table.
 * 
 */
@Entity
@Table(name="tb_product")
public class TbProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private String nameProduct;
	
	@Column(name="expiration_date")
	private Date expirationDate;

	private BigDecimal price_Product;
	
	private BigDecimal price_sale;
	
	private int status;

	//bi-directional many-to-one association to TbKardex
	@OneToMany(fetch = FetchType.EAGER, mappedBy="tbProduct")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<TbKardex> tbKardexs;

	//bi-directional many-to-one association to TbPresentation
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPresentation", nullable = false)
	private TbPresentation tbPresentation;

	public TbProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getNameProduct() {
		return this.nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public BigDecimal getPrice_Product() {
		return this.price_Product;
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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<TbKardex> getTbKardexs() {
		return this.tbKardexs;
	}

	public void setTbKardexs(Set<TbKardex> tbKardexs) {
		this.tbKardexs = tbKardexs;
	}

	public TbKardex addTbKardex(TbKardex tbKardex) {
		getTbKardexs().add(tbKardex);
		tbKardex.setTbProduct(this);

		return tbKardex;
	}

	public TbKardex removeTbKardex(TbKardex tbKardex) {
		getTbKardexs().remove(tbKardex);
		tbKardex.setTbProduct(null);

		return tbKardex;
	}

	public TbPresentation getTbPresentation() {
		return this.tbPresentation;
	}

	public void setTbPresentation(TbPresentation tbPresentation) {
		this.tbPresentation = tbPresentation;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}