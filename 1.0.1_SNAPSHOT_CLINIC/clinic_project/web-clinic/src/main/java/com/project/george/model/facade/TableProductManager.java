package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbProduct;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dto.ProductDTO;

public interface TableProductManager {
	
	public List<ProductDTO> listSpecificProduct(String nameProduct) throws Exception;
	public List<ProductDTO> listAllTypeProduct() throws Exception;
	public String addNewTypeProduct(TbProduct tbTypeProductBean) throws Exception;
	public String deleteTypeProduct(int idTypeProduct) throws Exception;
	
	//-----------------------------------
	public BeanResponseWeb setBeanProduct(ProductDTO beanProductDTO)throws Exception;
	public BeanResponseWeb findProductByName(String nameProduct)throws Exception;
	public BeanResponseWeb saveProduct(ProductDTO beanProductDTO)throws Exception;
	public BeanResponseWeb listProduct() throws Exception;
	public BeanResponseWeb updateProduct(ProductDTO beanProductDTO) throws Exception;
	public BeanResponseWeb deleteProduct(int idProduct) throws Exception;
}
