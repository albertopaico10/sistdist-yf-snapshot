package com.project.george.model.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;

@Service
@Transactional
public class ResponseUtilManagerImpl implements ResponseUtilManager {

	public String responsesKardex(List<TbKardexDTO> beanKardexDTO)throws Exception {
		StringBuilder responseKardex= new StringBuilder();
		responseKardex.append("<br/>");
		responseKardex.append("<div id='idTitleList'><label class='titlePage'>Maestro Kardex</label></div>");
		responseKardex.append("<table class='tableStyle' border='1'>");
		responseKardex.append("<tbody>");
		responseKardex.append("<tr class='thStyle'>");
		responseKardex.append("<th >ID</th>");
		responseKardex.append("<th >Nombre Producto</th>");
		responseKardex.append("<th >Nombre de la Presentación</th>");
		responseKardex.append("<th >Cantidad Total</th>");
		responseKardex.append("<th >Total Ingreso</th>");
		responseKardex.append("<th >Total Egreso</th>");
		responseKardex.append("<th >Detalle</th>");
		responseKardex.append("</tr>");
		for(TbKardexDTO beanKardexLocal:beanKardexDTO){
			responseKardex.append("<tr>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getId()+"</td>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getNameProduct()+"</td>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getNamePresentation()+"</td>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getCountProduct()+"</td>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getTotalEntry()+"</td>");
			responseKardex.append("<td class='tdDatatable'>"+beanKardexLocal.getTotalEgress()+"</td>");
			responseKardex.append("<td></td>");
			responseKardex.append("</tr>");
		}
		responseKardex.append("</tbody>");
		responseKardex.append("</table>");
		return responseKardex.toString();
	}
	
	public String responsesDetailKardex(List<TbDetailKardexDTO> beanKardexDTO)throws Exception {
		StringBuilder responseDetailKardex= new StringBuilder();
		responseDetailKardex.append("<div id='idTitleList'><label class='titlePage'>Detalle del Kardex</label></div>");
		responseDetailKardex.append("<table class='tableStyle' border='1'>");
		responseDetailKardex.append("<tbody>");
		responseDetailKardex.append("<tr class='thStyle'>");
		responseDetailKardex.append("<th >ID</th>");
		responseDetailKardex.append("<th >Cantidad</th>");
		responseDetailKardex.append("<th >Tipo Operacion</th>");
		responseDetailKardex.append("<th >Fecha</th>");
		responseDetailKardex.append("<th >Comprobante clase</th>");
		responseDetailKardex.append("<th >Comprobante numero</th>");
		responseDetailKardex.append("<th >Venta Diaria</th>");
		responseDetailKardex.append("</tr>");
		for(TbDetailKardexDTO beanDetailForm : beanKardexDTO){
			responseDetailKardex.append("<tr>");
			String classTable=CommonUtil.classTable;
			if("1".equals(beanDetailForm.getTypeOperation())){
				classTable=CommonUtil.classTableRed;
			}
			else{
				classTable=CommonUtil.classTableBlue;
			}
			responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getId()+"</td>");
			responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getCantidad()+"</td>");
			if("1".equals(beanDetailForm.getTypeOperation())){
				responseDetailKardex.append("<td class='"+classTable+"'>Entrada</td>");
			}
			else{
				responseDetailKardex.append("<td class='"+classTable+"'>Salida</td>");
			}
			responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getDateCreated()+"</td>");
			responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getComprobanteClase()+"</td>");
			responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getComprobanteNumero()+"</td>");			
			if(!"1".equals(beanDetailForm.getTypeOperation())){
				responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getPriceSale().multiply(new BigDecimal(beanDetailForm.getCantidad()))+"</td>");
			}else{
				responseDetailKardex.append("<td class='"+classTable+"'>"+beanDetailForm.getPriceProduct().multiply(new BigDecimal(beanDetailForm.getCantidad()))+"</td>");
			}
			
			responseDetailKardex.append("</tr>");
		}
		
		responseDetailKardex.append("</tbody>");
		responseDetailKardex.append("</table>");
		return responseDetailKardex.toString();
	}
	
//	public String responsesDetailKardex(List<TbKardexDTO> beanKardexDTO)throws Exception {
//		
//	}

	
}

