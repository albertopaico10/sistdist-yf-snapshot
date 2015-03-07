package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbArea;
import com.project.george.model.TbProduct;
import com.project.george.model.dto.TbProductDTO;

public interface TableProductManager {
	
	public List<TbProductDTO> listSpecificProduct(String nameProduct) throws Exception;
	public List<TbProductDTO> listAllTypeProduct() throws Exception;
	public String addNewTypeProduct(TbProduct tbTypeProductBean) throws Exception;
	public String deleteTypeProduct(int idTypeProduct) throws Exception;

}
