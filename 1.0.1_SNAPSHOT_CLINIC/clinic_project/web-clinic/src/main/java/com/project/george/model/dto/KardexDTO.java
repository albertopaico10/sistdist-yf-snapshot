package com.project.george.model.dto;

import java.math.BigDecimal;

public class KardexDTO {

	public int id;
	public String nameProduct;
	public String description;
	public int countProduct;
	public int totalEgress;
	public int totalEntry;
	public int idProduct;
	public String namePresentation;
	public BigDecimal priceTotalProduct;
	public BigDecimal priceTotalSale;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCountProduct() {
		return countProduct;
	}
	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}
	public int getTotalEgress() {
		return totalEgress;
	}
	public void setTotalEgress(int totalEgress) {
		this.totalEgress = totalEgress;
	}
	public int getTotalEntry() {
		return totalEntry;
	}
	public void setTotalEntry(int totalEntry) {
		this.totalEntry = totalEntry;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNamePresentation() {
		return namePresentation;
	}
	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
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
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
}
