package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dto.DetailKardexDTO;
import com.project.george.model.dto.KardexDTO;

public interface TableKardexManager {

	public List<KardexDTO> listKardexByProduct(int idProduct) throws Exception;
	public List<DetailKardexDTO> listDetailKardex(int kardexId) throws Exception;
	public String addNewRegisterKardex(String idProduct,
			String cantidad,String comprobanteClase,
			String comprobanteNumber,String idKardex,String typeOperation)throws Exception;
	public boolean validateIfExistProductInStock(String cantidad,String idKardex)throws Exception;
	//=======================================================================================
	public BeanResponseWeb findKardexByIdProduct(String idProduct) throws Exception;
	public BeanResponseWeb saveKardex(String productId,String cantidad,String comprobanteClase,String comprobanteNumber,
			String idKardex,String typeOperation)throws Exception;
	public BeanResponseWeb getListKardexDetail(String idKardex)throws Exception;
}
