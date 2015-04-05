package com.project.george.bean.kardex;

import java.math.BigDecimal;

public class BeanResponseKardex {

	public int id;
	public int idProduct;
	public String nameProduct;
	public String namePresentation;
	public double priceProductKardex;
	public int countProduct;
	public int status;
	public int totalProductEntry;
	public int totalProductEgress;
	public String description;
	public String dateCreated;
	public BigDecimal priceTotalProduct;
	public BigDecimal priceTotalSale;
	public String result;
	public String messages;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public double getPriceProductKardex() {
		return priceProductKardex;
	}
	public void setPriceProductKardex(double priceProductKardex) {
		this.priceProductKardex = priceProductKardex;
	}
	public int getCountProduct() {
		return countProduct;
	}
	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotalProductEntry() {
		return totalProductEntry;
	}
	public void setTotalProductEntry(int totalProductEntry) {
		this.totalProductEntry = totalProductEntry;
	}
	public int getTotalProductEgress() {
		return totalProductEgress;
	}
	public void setTotalProductEgress(int totalProductEgress) {
		this.totalProductEgress = totalProductEgress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public BigDecimal getPriceTotalProduct() {
		return priceTotalProduct;
	}
	public void setPriceTotalProduct(BigDecimal priceTotalProduct) {
		this.priceTotalProduct = priceTotalProduct;
	}
	public BigDecimal getPriceTotalSale() {
		return priceTotalSale;
	}
	public void setPriceTotalSale(BigDecimal priceTotalSale) {
		this.priceTotalSale = priceTotalSale;
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
	
	
	
}
