package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbProduct;
import com.project.george.model.dao.TableProductDao;
import com.project.george.model.dto.TbProductDTO;

@Service
@Transactional
public class TableProductManagerImpl implements TableProductManager {
	@Autowired
	TableProductDao customTableTypeProduct;
	
	public List<TbProductDTO> listSpecificProduct(String nameProduct)
			throws Exception {
		List<TbProduct> listAllData=customTableTypeProduct.listSpecificProduct(nameProduct);
		
		List<TbProductDTO> newListAll=new ArrayList<TbProductDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		for (TbProduct beanTableDB:listAllData) {
			TbProductDTO beanDTO=new TbProductDTO();
			beanDTO=utilMethods.copyValuesTypeProductDTO(beanTableDB, beanDTO);
			newListAll.add(beanDTO);
		}
		if(newListAll.size()==0){
			newListAll=null;
		}
		
		return newListAll;
	}
		
	public List<TbProductDTO> listAllTypeProduct() throws Exception {
		System.out.println("Inside listAllPresentation");
		List<TbProduct> listAllData=customTableTypeProduct.listAllTypeProduct();
		
		List<TbProductDTO> newListAll=new ArrayList<TbProductDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for (TbProduct beanTableDB:listAllData) {
			TbProductDTO beanDTO=new TbProductDTO();
			beanDTO=utilMethods.copyValuesTypeProductDTO(beanTableDB, beanDTO);
			newListAll.add(beanDTO);
		}
		if(newListAll.size()==0){
			newListAll=null;
		}
		return newListAll;
	}


	public String addNewTypeProduct(TbProduct tbTypeProductBean)
			throws Exception {
		String returnRsponse=CommonUtil.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW;
		try {
			customTableTypeProduct.addNewMantenience(tbTypeProductBean);
		} catch (Exception e) {
			returnRsponse=CommonUtil.ERROR;
		}		
		return returnRsponse;
	}


	public String deleteTypeProduct(int idTypeProduct) throws Exception {
		String returnRsponse=CommonUtil.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW;
		TbProduct tbTypeProduct=new TbProduct();
		tbTypeProduct=customTableTypeProduct.beanProductSpecific(idTypeProduct);
		tbTypeProduct.setId(idTypeProduct);
		tbTypeProduct.setStatus(2);
		customTableTypeProduct.deleteValueMantenience(tbTypeProduct);
		return returnRsponse;
	}


	
	
}
