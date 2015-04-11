package com.project.george.model.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DetailKardexDTO {

	public int id;
	public int cantidad;
	public String typeOperation;
	public String comprobanteClase;
	public String comprobanteNumero;
	public BigDecimal priceProduct;
	public BigDecimal priceSale;
	public String dateCreated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public String getComprobanteClase() {
		return comprobanteClase;
	}
	public void setComprobanteClase(String comprobanteClase) {
		this.comprobanteClase = comprobanteClase;
	}
	
//	public int getComprobanteNumero() {
//		return comprobanteNumero;
//	}
//	public void setComprobanteNumero(int comprobanteNumero) {
//		this.comprobanteNumero = comprobanteNumero;
//	}
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
//	public Timestamp getDateCreated() {
//		return dateCreated;
//	}
//	public void setDateCreated(Timestamp dateCreated) {
//		this.dateCreated = dateCreated;
//	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getComprobanteNumero() {
		return comprobanteNumero;
	}
	public void setComprobanteNumero(String comprobanteNumero) {
		this.comprobanteNumero = comprobanteNumero;
	}
	
	
	
}
