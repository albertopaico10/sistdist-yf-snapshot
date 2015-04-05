package com.project.george.bean.product.canonical;

import java.util.List;

import com.project.george.bean.product.BeanResponseProduct;

public class BeanResponseCanonicalListProduct {

	public String listCadenaProduct;
	public List<BeanResponseProduct> listProductObj;
	public String result;
	public String messages;
	
	
	public String getListCadenaProduct() {
		return listCadenaProduct;
	}
	public void setListCadenaProduct(String listCadenaProduct) {
		this.listCadenaProduct = listCadenaProduct;
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
	public List<BeanResponseProduct> getListProductObj() {
		return listProductObj;
	}
	public void setListProductObj(List<BeanResponseProduct> listProductObj) {
		this.listProductObj = listProductObj;
	}
	
	
}
