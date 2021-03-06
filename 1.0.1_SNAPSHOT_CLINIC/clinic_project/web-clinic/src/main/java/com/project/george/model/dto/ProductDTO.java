package com.project.george.model.dto;

import java.math.BigDecimal;

public class ProductDTO {
	
	public int id;
	public String nameProduct;
	public int status;
	public int idPresentation;
	public String namePresentation;
	public BigDecimal price;
	public BigDecimal priceSale;
	public String expirationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdPresentation() {
		return idPresentation;
	}
	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}
	public String getNamePresentation() {
		return namePresentation;
	}
	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
