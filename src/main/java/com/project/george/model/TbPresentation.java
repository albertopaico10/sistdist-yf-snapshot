package com.project.george.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tb_presentation database table.
 * 
 */
@Entity
@Table(name="tb_presentation")
public class TbPresentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private String namePresentation;

	private int status;

	//bi-directional many-to-one association to TbProduct
	@OneToMany(fetch = FetchType.LAZY,  mappedBy="tbPresentation")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TbProduct> tbProducts;

	public TbPresentation() {
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

	public String getNamePresentation() {
		return this.namePresentation;
	}

	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TbProduct> getTbProducts() {
		return this.tbProducts;
	}

	public void setTbProducts(List<TbProduct> tbProducts) {
		this.tbProducts = tbProducts;
	}

	public TbProduct addTbProduct(TbProduct tbProduct) {
		getTbProducts().add(tbProduct);
		tbProduct.setTbPresentation(this);

		return tbProduct;
	}

	public TbProduct removeTbProduct(TbProduct tbProduct) {
		getTbProducts().remove(tbProduct);
		tbProduct.setTbPresentation(null);

		return tbProduct;
	}

}