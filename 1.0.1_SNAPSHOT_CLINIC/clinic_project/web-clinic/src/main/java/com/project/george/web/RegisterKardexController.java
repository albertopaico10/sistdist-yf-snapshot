package com.project.george.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.george.common.CommonUtil;
import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;
import com.project.george.model.dto.TbProductDTO;
import com.project.george.model.facade.ResponseUtilManager;
import com.project.george.model.facade.TableKardexManager;
import com.project.george.model.facade.TableProductManager;

@Controller
public class RegisterKardexController {

	@Autowired
	TableProductManager tableProduct;
	
	@Autowired
	TableKardexManager tableKardexManager;
	
	@Autowired
	ResponseUtilManager responseUtilManager;
	
	@RequestMapping("registerKardex.htm")
    public ModelAndView registerKardex (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside registerKardex htm");
		
		String responseStr=CommonUtil.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		
		return new ModelAndView(responseStr);
	}
	
	@RequestMapping("findProduct.htm")
    public ModelAndView findProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside findProduct htm");		
//		String returnRsponse=CommonUtil.RegisterKardex.REDIRECT_REGISTER_KARDEX;
		String returnRsponse=CommonUtil.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		System.out.println("Request Parameter : "+nameProduct);
		try {
			List<TbProductDTO> listAllProduct=tableProduct.listSpecificProduct(nameProduct);
			System.out.println("Cantidad de filas que trae :"+listAllProduct.size());
			request.setAttribute("listProduct", listAllProduct);
			request.setAttribute("nameProduct", nameProduct);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	
	@RequestMapping("listKardexByProduct.htm")
    public ModelAndView listKardexByProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside findProduct htm");		
		String returnRsponse=CommonUtil.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		final String productId = String.valueOf(request.getParameter("productId"));
		System.out.println("Request Parameter : "+nameProduct);
		try {
			List<TbProductDTO> listAllProduct=tableProduct.listSpecificProduct(nameProduct);
			System.out.println("Cantidad de filas que trae :"+listAllProduct.size());
			request.setAttribute("listProduct", listAllProduct);
			request.setAttribute("nameProduct", nameProduct);
			request.setAttribute("productId", productId);
			List<TbKardexDTO> listKardexByProduct = tableKardexManager.listKardexByProduct(Integer.parseInt(productId));
			request.setAttribute("listKardex", listKardexByProduct);
			request.setAttribute("valueKardexList", "1");
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	@RequestMapping("saveKardexByProduct.htm")
    public ModelAndView saveKardexByProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside saveKardexByProduct htm");		
		String returnRsponse=CommonUtil.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		final String productId = String.valueOf(request.getParameter("productId"));
		final String cantidad = String.valueOf(request.getParameter("cantidad"));
		final String comprobanteClase = String.valueOf(request.getParameter("comprobanteClase"));
		final String comprobanteNumber = String.valueOf(request.getParameter("comprobanteNumber"));
		final String idKardex = String.valueOf(request.getParameter("idKardex"));
		final String typeOperation = String.valueOf(request.getParameter("typeOperation"));
		//--Validate if exist product in stock.
		boolean resultStock=false;
		if(CommonUtil.RegisterKardex.TYPE_OPERATION_EGRESS.equals(typeOperation)){
			try {
				resultStock=tableKardexManager.validateIfExistProductInStock(cantidad, idKardex);
			} catch (Exception e) {
				System.out.println("Error : "+e.toString());
			}
		}
		try {
			if(!resultStock){
				tableKardexManager.addNewRegisterKardex(productId, cantidad,comprobanteClase, comprobanteNumber,idKardex,typeOperation);
			}
			List<TbKardexDTO> listKardexByProduct = tableKardexManager.listKardexByProduct(Integer.parseInt(productId));
			request.setAttribute("listKardex", listKardexByProduct);
			for(TbKardexDTO beanKardexDTO:listKardexByProduct){
				request.setAttribute("idKardexController", beanKardexDTO.getId());	
			}
			List<TbProductDTO> listAllProduct=tableProduct.listSpecificProduct(nameProduct);
			System.out.println("Cantidad de filas que trae :"+listAllProduct.size());
			request.setAttribute("listProduct", listAllProduct);
			request.setAttribute("nameProduct", nameProduct);
			request.setAttribute("productId", productId);
			if(resultStock){
				request.setAttribute("errorStockProduct", "error");	
			}
			
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	@RequestMapping(value = "/listDetailKardex.htm", method = RequestMethod.GET)
	public @ResponseBody
	String strDetailKardex(@RequestParam String kardexId) {
		System.out.println("ENTREEEEEEEEEEEEEE" + kardexId);
		List<TbDetailKardexDTO> listDetailKardexByProduct = null;
		String responseJSP="";
		try {
			listDetailKardexByProduct = tableKardexManager.listDetailKardex(Integer.parseInt(kardexId));			
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
			e.printStackTrace();
		}
		if(listDetailKardexByProduct==null){
			System.out.println("ES NULL");
			responseJSP=CommonUtil.ReturnAJAX.IS_NULL;
		}else if(listDetailKardexByProduct.size()>0){
			try {
				responseJSP=responseUtilManager.responsesDetailKardex(listDetailKardexByProduct);
			} catch (Exception e) {
				System.out.println("Error : "+e.toString());
			}
		}
		System.out.println("VALOR RESPONSES : ");
		return responseJSP;
	}
	
}
