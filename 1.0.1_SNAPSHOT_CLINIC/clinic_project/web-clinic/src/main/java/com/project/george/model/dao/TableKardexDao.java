package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbKardex;

public interface TableKardexDao {

	public List<TbKardex> listKardexByProduct(int idProduct);
	public int addNewKardex(TbKardex tbKardexBean)throws Exception;
	public int updateKardex(TbKardex tbKardexBean)throws Exception;
	public void updateSQL(TbKardex tbKardexBean);
	public List<TbKardex> listStockProduct(String idKardex);
}
