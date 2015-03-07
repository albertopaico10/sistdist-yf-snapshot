package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbProduct;

public interface TableProductDao {
	List<TbProduct> listSpecificProduct(String nameProduct);
	List<TbProduct> listAllTypeProduct();
	void addNewMantenience(TbProduct tbTypeProductBean);
	TbProduct beanProductSpecific(int idValue);
	List<TbProduct> listSpecificProductById(String idProduct);
	void deleteValueMantenience(TbProduct tbTypeProductBean);
}
