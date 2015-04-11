package com.project.george.bean.kardex;

import java.math.BigDecimal;

public class BeanResponseKardexDetail {

	public int id;
	public int idKardex;
	public int typeOperation;
	public int status;
	public String comprobanteClase;
	public String comprobanteNumero;
	public BigDecimal priceProduct;
	public BigDecimal priceSale;
	public int cantidad;
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
//	public int getComprobanteNumero() {
//		return comprobanteNumero;
//	}
//	public void setComprobanteNumero(int comprobanteNumero) {
//		this.comprobanteNumero = comprobanteNumero;
//	}
	
	public BigDecimal getPriceProduct() {
		return priceProduct;
	}
	public String getComprobanteNumero() {
		return comprobanteNumero;
	}
	public void setComprobanteNumero(String comprobanteNumero) {
		this.comprobanteNumero = comprobanteNumero;
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
