package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbDetailKardex;

public interface TableDetailKardexDao {
	public List<TbDetailKardex> listDetailKardexByKardexId(int idKardex)throws Exception;
	public void addNewDetailKardex(TbDetailKardex tbDetailKardexBean);
	public void addNew_DetailKardex(TbDetailKardex tbDetailKardexBean);
}
