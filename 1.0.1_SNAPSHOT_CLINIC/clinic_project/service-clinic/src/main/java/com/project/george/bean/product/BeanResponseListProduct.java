package com.project.george.bean.product;

import java.util.List;

import com.project.george.bean.product.canonical.BeanResponseCanonicalProduct;

public class BeanResponseListProduct {
	public List<BeanResponseCanonicalProduct> listResponseProduct;
	public String result;
	
	public List<BeanResponseCanonicalProduct> getListResponseProduct() {
		return listResponseProduct;
	}

	public void setListResponseProduct(
			List<BeanResponseCanonicalProduct> listResponseProduct) {
		this.listResponseProduct = listResponseProduct;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
