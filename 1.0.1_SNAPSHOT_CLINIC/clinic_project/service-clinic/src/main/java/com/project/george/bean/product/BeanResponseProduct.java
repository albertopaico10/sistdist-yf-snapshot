package com.project.george.bean.product;

import java.math.BigDecimal;
import java.util.Date;

public class BeanResponseProduct {

	public int id;
	public String nameProduct;
	public int status;
	public int idPresentation;
	public String namePresentation;
	public BigDecimal priceProduct;
	public BigDecimal priceSale;
	public String expirationDate;
	public String result;
	public String messages;
	public String dateCreated;
	
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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
	public BigDecimal getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(BigDecimal priceProduct) {
		this.priceProduct = priceProduct;
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
