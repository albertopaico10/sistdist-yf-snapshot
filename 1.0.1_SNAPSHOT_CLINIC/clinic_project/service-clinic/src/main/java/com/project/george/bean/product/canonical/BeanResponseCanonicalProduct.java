package com.project.george.bean.product.canonical;

import java.math.BigDecimal;

public class BeanResponseCanonicalProduct {

	public int id;
	public String nameProduct;
	public String namePresentation;
	public int status;
	public int idPresentation;
	public BigDecimal priceProduct;
	public String dateCreated;
	public BigDecimal priceSale;
	public String expirationDate;
	public String result;
	public String messages;
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
	public String getNamePresentation() {
		return namePresentation;
	}
	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
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
	public BigDecimal getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(BigDecimal priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
}
