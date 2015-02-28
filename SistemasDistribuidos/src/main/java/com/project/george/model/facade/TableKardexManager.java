package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;

public interface TableKardexManager {

	public List<TbKardexDTO> listKardexByProduct(int idProduct) throws Exception;
	public List<TbDetailKardexDTO> listDetailKardex(int kardexId) throws Exception;
	public String addNewRegisterKardex(String idProduct,
			String cantidad,String comprobanteClase,
			String comprobanteNumber,String idKardex,String typeOperation)throws Exception;
	public boolean validateIfExistProductInStock(String cantidad,String idKardex)throws Exception;
}
