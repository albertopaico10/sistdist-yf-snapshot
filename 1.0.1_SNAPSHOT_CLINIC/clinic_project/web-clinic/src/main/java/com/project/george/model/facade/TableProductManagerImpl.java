package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.bean.catalog.product.BeanProduct;
import com.project.george.bean.catalog.product.BeanRequestProduct;
import com.project.george.common.CommonConstants;
import com.project.george.common.UtilMethods;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.model.TbProduct;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dao.TableProductDao;
import com.project.george.model.dto.ProductDTO;

@Service
@Transactional
public class TableProductManagerImpl implements TableProductManager {
	@Autowired
	TableProductDao customTableTypeProduct;
	
	@Autowired
	public ClinicApplicationBusiness clinicApplicationBusiness;
	
	public List<ProductDTO> listSpecificProduct(String nameProduct)
			throws Exception {
		List<TbProduct> listAllData=customTableTypeProduct.listSpecificProduct(nameProduct);
		
		List<ProductDTO> newListAll=new ArrayList<ProductDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		for (TbProduct beanTableDB:listAllData) {
			ProductDTO beanDTO=new ProductDTO();
			beanDTO=utilMethods.copyValuesTypeProductDTO(beanTableDB, beanDTO);
			newListAll.add(beanDTO);
		}
		if(newListAll.size()==0){
			newListAll=null;
		}
		
		return newListAll;
	}
		
	public List<ProductDTO> listAllTypeProduct() throws Exception {
		System.out.println("Inside listAllPresentation");
		List<TbProduct> listAllData=customTableTypeProduct.listAllTypeProduct();
		
		List<ProductDTO> newListAll=new ArrayList<ProductDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for (TbProduct beanTableDB:listAllData) {
			ProductDTO beanDTO=new ProductDTO();
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
		String returnRsponse=CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW;
		try {
			customTableTypeProduct.addNewMantenience(tbTypeProductBean);
		} catch (Exception e) {
			returnRsponse=CommonConstants.ERROR;
		}		
		return returnRsponse;
	}


	public String deleteTypeProduct(int idTypeProduct) throws Exception {
		String returnRsponse=CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW;
		TbProduct tbTypeProduct=new TbProduct();
		tbTypeProduct=customTableTypeProduct.beanProductSpecific(idTypeProduct);
		tbTypeProduct.setId(idTypeProduct);
		tbTypeProduct.setStatus(2);
		customTableTypeProduct.deleteValueMantenience(tbTypeProduct);
		return returnRsponse;
	}

	public BeanResponseWeb setBeanProduct(ProductDTO beanProductDTO) throws Exception {
		BeanRequestProduct beanProduct=new BeanRequestProduct();
		beanProduct.setNamePresentation(beanProduct.getNameProduct());
		beanProduct.setIdPresentation(beanProductDTO.getIdPresentation());
		beanProduct.setNameProduct(beanProductDTO.getNameProduct());
		beanProduct.setPrice(beanProductDTO.getPrice());
		beanProduct.setPriceSale(beanProductDTO.getPriceSale());
		
		BeanProduct beanResponseProduct=clinicApplicationBusiness.saveProduct(beanProduct);
		
		BeanResponseWeb beanResponseWeb=new BeanResponseWeb();
		if(CommonConstants.ResponseIdResult.RESULT_CORRECT.equals(beanResponseProduct.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW);
			beanResponseWeb.setMessage("Se grabo con Exito...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_EXIST_PRODUCT.equals(beanResponseProduct.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW);
			beanResponseWeb.setMessage("El Producto que esta ingresando ya Existe");
		}
		if(beanResponseWeb.getRedirectTo().isEmpty()){
			beanResponseWeb.setRedirectTo(CommonConstants.ErrorPage.RESPONSE_ERROR_PAGE);
			beanResponseWeb.setMessage("Hubo un Error en los Servicios. Comuniquese con el Administrador");
		}
		return beanResponseWeb;
	}


	
	
}
