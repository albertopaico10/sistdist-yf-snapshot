package com.project.george.bean.kardex.canonical;

import java.math.BigDecimal;

public class BeanResponseCanonicalKardexDetail {

	public int id;
	public int idKardex;
	public int cantidad;
	public int typeOperation;
	public int status;
	public String comprobanteClase;
	public int comprobanteNumber;
	public BigDecimal priceProduct;
	public BigDecimal priceSale;
	public String result;
	public String messages;
	public String dateCreated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdKardex() {
		return idKardex;
	}
	public void setIdKardex(int idKardex) {
		this.idKardex = idKardex;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(int typeOperation) {
		this.typeOperation = typeOperation;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComprobanteClase() {
		return comprobanteClase;
	}
	public void setComprobanteClase(String comprobanteClase) {
		this.comprobanteClase = comprobanteClase;
	}
	public int getComprobanteNumber() {
		return comprobanteNumber;
	}
	public void setComprobanteNumber(int comprobanteNumber) {
		this.comprobanteNumber = comprobanteNumber;
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
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
