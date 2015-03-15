package com.project.george.model.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbDetailKardex;
import com.project.george.model.TbKardex;
import com.project.george.model.TbProduct;
import com.project.george.model.custom.dao.CustomTableProductDao;
import com.project.george.model.custom.dao.CustomTableProductDaoImpl;
import com.project.george.model.dao.TableDetailKardexDao;
import com.project.george.model.dao.TableKardexDao;
import com.project.george.model.dao.TableKardexDaoImpl;
import com.project.george.model.dao.TableProductDao;
import com.project.george.model.dao.TableProductDaoImpl;
import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;
import com.project.george.model.dto.TbProductDTO;


@Service
@Transactional
public class TableKardexManagerImpl implements TableKardexManager{
	
	@Autowired
	TableKardexDao customTableKardexDao;
	
	@Autowired
	TableDetailKardexDao customTableDetailKardexDao;
	
	@Autowired
	TableProductDao customTableProductDao;

	public List<TbKardexDTO> listKardexByProduct(int idProduct) throws Exception{
		System.out.println("Inside listKardexByProduct");
		List<TbKardex> listKardex=customTableKardexDao.listKardexByProduct(idProduct);
		
		List<TbKardexDTO> newListKardex=new ArrayList<TbKardexDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		for (TbKardex beanKardex:listKardex){
			TbKardexDTO beanKardexDTO=new TbKardexDTO();
			beanKardexDTO=utilMethods.copyValuesTbKardexDTO(beanKardex, beanKardexDTO);
			System.out.println("Valores que envia : "+beanKardexDTO.getId()+"**"+beanKardexDTO.getNameProduct()+"***"+beanKardexDTO.getCountProduct());
			newListKardex.add(beanKardexDTO);
		}
		if(newListKardex.size()==0){
			newListKardex=null;
		}
		return newListKardex;
	}
	
	public String addNewRegisterKardex(String idProduct,
			String cantidad,String comprobanteClase,
			String comprobanteNumber,String idKardexController,String typeOperation)throws Exception{
		String responsesAjax=CommonUtil.RegisterKardex.RESPONSES_SUCCESS;
		int idKardex=0;
		TbKardex beanKardex=new TbKardex();
		System.out.println("Estoy aqui addNewRegisterKardex");

		TbProduct beanProuctKardex=customTableProductDao.beanProductSpecific(Integer.parseInt(idProduct));
		
		beanKardex.setTbProduct(beanProuctKardex);
		beanKardex.setStatus(CommonUtil.STATUS_ACTIVE);
		System.out.println("SALI DE BUSCAR PRODUCTO ESPECIFICO");
		
		beanKardex.setPriceTotalProduct(BigDecimal.valueOf(0));
		beanKardex.setPriceTotalSale(BigDecimal.valueOf(0));
		beanKardex.setPriceKardex(BigDecimal.valueOf(0));
		if(!"".equals(idKardexController)){
			beanKardex.setId(Integer.parseInt(idKardexController));
		}else{
			//insert master
			idKardex=customTableKardexDao.addNewKardex(beanKardex);
			beanKardex.setId(idKardex);
		}
		
		//--Add Detail
		TbDetailKardex beanDetailKardex=new TbDetailKardex();
		beanDetailKardex.setId(0);
		beanDetailKardex.setCantidad(Integer.parseInt(cantidad));
		beanDetailKardex.setTypeOperation(typeOperation);
		beanDetailKardex.setComprobante_clase(comprobanteClase);
		beanDetailKardex.setComprobante_number(Integer.parseInt(comprobanteNumber));
		beanDetailKardex.setStatus(CommonUtil.STATUS_ACTIVE);
		beanDetailKardex.setPrice_Product(beanProuctKardex.getPrice_Product());
		beanDetailKardex.setPrice_sale(beanProuctKardex.getPrice_sale());
		beanDetailKardex.setTbKardex(beanKardex);
		
		Set<TbDetailKardex> set=new HashSet<TbDetailKardex>();
		set.add(beanDetailKardex);
		beanKardex.setTbDetailKardexs(set);
		//--insert detail
		customTableDetailKardexDao.addNew_DetailKardex(beanDetailKardex);
		try {
			System.out.println("ID in Manager : "+beanKardex.getId());
			List<TbDetailKardex> listDetailKardex=customTableDetailKardexDao.listDetailKardexByKardexId(beanKardex.getId());
			updateHeaderMasterKardex(beanKardex, listDetailKardex);			
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
			responsesAjax=CommonUtil.ERROR;
			e.printStackTrace();
		}		
		System.out.println("RESPONSE FROM MANAGER : "+responsesAjax);
		return responsesAjax;
	}
	
	public void updateHeaderMasterKardex(TbKardex beanKardex,List<TbDetailKardex> listDetailKardex)throws Exception{
		int countTotal=0,totalEntry=0,totalEgress=0;
		BigDecimal totalProduct=new BigDecimal("0.0");
		BigDecimal partialTotalProduct=new BigDecimal("0.0");
		double totalProductDouble=0.0,totalSaleDouble=0.0;
		BigDecimal totalSale=new BigDecimal("0.0");
		BigDecimal partialTotalSale=new BigDecimal("0.0");
		for (TbDetailKardex beanDetail:listDetailKardex) {
			if(CommonUtil.RegisterKardex.TYPE_OPERATION_ENTRY.equals(beanDetail.getTypeOperation())){
				totalEntry+=beanDetail.getCantidad();
//				dTotalProduct+=beanDetail.getCantidad()*beanDetail.getPrice_Product().longValue();
				partialTotalProduct=beanDetail.getPrice_Product().multiply(new BigDecimal(beanDetail.getCantidad()));
				totalProductDouble+=partialTotalProduct.doubleValue();
			}
			else{
				totalEgress+=beanDetail.getCantidad();
//				dTotalSale+=beanDetail.getCantidad()*beanDetail.getPrice_sale().longValue();
				partialTotalSale=beanDetail.getPrice_sale().multiply(new BigDecimal(beanDetail.getCantidad()));
				totalSaleDouble+=partialTotalSale.doubleValue();
			}
		}
		totalProduct=new BigDecimal(totalProductDouble);
		totalSale=new BigDecimal(totalSaleDouble);
		countTotal=totalEntry-totalEgress;
		System.out.println("Info ---> Count Total :"+countTotal+"** Total Entrada : "+totalEntry+"** Tota Egreso : "+totalEgress);
		System.out.println("Info--> Total Valor Compra o inversion : "+totalProduct.toString()+"//"+totalProduct+"//"+totalProduct.longValue()+"**** Total recuperado : "+totalSale.toString()+"//"+totalSale+"//"+totalSale.longValue());
		beanKardex.setCountProduct(countTotal);
		beanKardex.setTotalEntry(totalEntry);
		beanKardex.setTotalEgress(totalEgress);
		beanKardex.setPriceTotalProduct(totalProduct);
		beanKardex.setPriceTotalSale(totalSale);
		
		//--Update KARDEX
		customTableKardexDao.updateSQL(beanKardex);
		
	}

	public List<TbDetailKardexDTO> listDetailKardex(int kardexId)
			throws Exception {
		List<TbDetailKardex> listDetailKardex=customTableDetailKardexDao.listDetailKardexByKardexId(kardexId);
		
		List<TbDetailKardexDTO> listBeanDetailKardexDTO=new ArrayList<TbDetailKardexDTO>();
		UtilMethods utilMethods=new UtilMethods();
		for(TbDetailKardex beanDetailKardex:listDetailKardex){
			TbDetailKardexDTO beanDetailKardexDTO=new TbDetailKardexDTO();
			beanDetailKardexDTO=utilMethods.copyValuesTbDetailKardexDTO(beanDetailKardex, beanDetailKardexDTO);
			listBeanDetailKardexDTO.add(beanDetailKardexDTO);
		}
		if(listBeanDetailKardexDTO.size()==0){
			listBeanDetailKardexDTO=null;
		}
		return listBeanDetailKardexDTO;
	}

	public boolean validateIfExistProductInStock(String cantidad,String idKardex) throws Exception {
		boolean result=false;
		List<TbKardex> listKardex=customTableKardexDao.listStockProduct(idKardex);
		for(TbKardex beanKardex:listKardex){
			if(Integer.parseInt(cantidad)>beanKardex.getCountProduct()){
				result=true;
			}
		}
		return result;
	}

}



