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

import com.project.george.common.CommonConstants;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dto.DetailKardexDTO;
import com.project.george.model.dto.KardexDTO;
import com.project.george.model.dto.ProductDTO;
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
		
		String responseStr=CommonConstants.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		
		return new ModelAndView(responseStr);
	}
	
	@RequestMapping("findProduct.htm")
    public ModelAndView findProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside findProduct htm");		
//		String returnRsponse=CommonUtil.RegisterKardex.REDIRECT_REGISTER_KARDEX;
		String returnRsponse=CommonConstants.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		System.out.println("Request Parameter : "+nameProduct);
		try {
//			List<ProductDTO> listAllProduct=tableProduct.listSpecificProduct(nameProduct);
			BeanResponseWeb beanResponseWeb=tableProduct.findProductByName(nameProduct);
			request.setAttribute("listProduct", beanResponseWeb.getListProductDTO());
			request.setAttribute("nameProduct", nameProduct);
			request.setAttribute("messages", beanResponseWeb.getStatusResponse());
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	
	@RequestMapping("listKardexByProduct.htm")
    public ModelAndView listKardexByProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside findProduct htm");		
		String returnRsponse=CommonConstants.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		final String productId = String.valueOf(request.getParameter("productId"));
		System.out.println("Request Parameter : "+nameProduct);
		try {
			BeanResponseWeb beanResponseWeb=tableProduct.findProductByName(nameProduct);
			request.setAttribute("listProduct", beanResponseWeb.getListProductDTO());
			request.setAttribute("nameProduct", nameProduct);
			request.setAttribute("productId", productId);
			
//			List<KardexDTO> listKardexByProduct = tableKardexManager.listKardexByProduct(Integer.parseInt(productId));
			BeanResponseWeb beanResponseWebKardex=tableKardexManager.findKardexByIdProduct(productId);
			request.setAttribute("listKardex", beanResponseWebKardex.getListKardexDTO());
			request.setAttribute("valueKardexList", "1");
			System.out.println("MESSAGES : "+beanResponseWebKardex.getStatusResponse());
			request.setAttribute("messages", beanResponseWebKardex.getStatusResponse());
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	@RequestMapping("saveKardexByProduct.htm")
    public ModelAndView saveKardexByProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside saveKardexByProduct htm");		
		String returnRsponse=CommonConstants.RegisterKardex.RESPONSES_REGISTER_KARDEX;
		final String nameProduct = String.valueOf(request.getParameter("nameProduct"));
		final String productId = String.valueOf(request.getParameter("productId"));
		final String cantidad = String.valueOf(request.getParameter("cantidad"));
		final String comprobanteClase = String.valueOf(request.getParameter("comprobanteClase"));
		final String comprobanteNumber = String.valueOf(request.getParameter("comprobanteNumber"));
		final String idKardex = String.valueOf(request.getParameter("idKardex"));
		final String typeOperation = String.valueOf(request.getParameter("typeOperation"));
		//--Validate if exist product in stock.
//		boolean resultStock=false;
//		if(CommonConstants.RegisterKardex.TYPE_OPERATION_EGRESS.equals(typeOperation)){
//			try {
//				resultStock=tableKardexManager.validateIfExistProductInStock(cantidad, idKardex);
//			} catch (Exception e) {
//				System.out.println("Error : "+e.toString());
//			}
//		}
		try {
			
			BeanResponseWeb beanResponseWeb=tableKardexManager.saveKardex(productId, cantidad,
					comprobanteClase, comprobanteNumber, idKardex, typeOperation);
			
//			if(!resultStock){
//				tableKardexManager.addNewRegisterKardex(productId, cantidad,comprobanteClase, comprobanteNumber,idKardex,typeOperation);
//			}
//			List<KardexDTO> listKardexByProduct = tableKardexManager.listKardexByProduct(Integer.parseInt(productId));
			request.setAttribute("listKardex", beanResponseWeb.getListKardexDTO());
			for(KardexDTO beanKardexDTO:beanResponseWeb.getListKardexDTO()){
				request.setAttribute("idKardexController", beanKardexDTO.getId());	
			}
			System.out.println("MESSAGES : "+beanResponseWeb.getStatusResponse());
			request.setAttribute("messages", beanResponseWeb.getStatusResponse());
			
			BeanResponseWeb beanResponseWebProduct=tableProduct.findProductByName(nameProduct);
			request.setAttribute("listProduct", beanResponseWebProduct.getListProductDTO());
			request.setAttribute("nameProduct", nameProduct);
			request.setAttribute("productId", productId);
//			List<ProductDTO> listAllProduct=tableProduct.listSpecificProduct(nameProduct);
//			System.out.println("Cantidad de filas que trae :"+listAllProduct.size());
//			request.setAttribute("listProduct", listAllProduct);
//			request.setAttribute("nameProduct", nameProduct);
//			request.setAttribute("productId", productId);
//			if(resultStock){
//				request.setAttribute("errorStockProduct", "error");	
//			}
			
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(returnRsponse);
	}
	
	@RequestMapping(value = "/listDetailKardex.htm", method = RequestMethod.GET)
	public @ResponseBody
	String strDetailKardex(@RequestParam String kardexId) {
		System.out.println("ENTREEEEEEEEEEEEEE" + kardexId);
//		List<TbDetailKardexDTO> listDetailKardexByProduct = null;
		String responseJSP="";
		BeanResponseWeb beaResponseWeb=null;
		try {
//			listDetailKardexByProduct = tableKardexManager.listDetailKardex(Integer.parseInt(kardexId));	
			beaResponseWeb=tableKardexManager.getListKardexDetail(kardexId);
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
			e.printStackTrace();
		}
		if(beaResponseWeb.getListDetailKardexDTO()==null){
			System.out.println("ES NULL");
			responseJSP=CommonConstants.ReturnAJAX.IS_NULL;
		}else if(beaResponseWeb.getListDetailKardexDTO().size()>0){
			try {
				responseJSP=responseUtilManager.responsesDetailKardex(beaResponseWeb.getListDetailKardexDTO());
			} catch (Exception e) {
				System.out.println("Error : "+e.toString());
			}
		}
		System.out.println("VALOR RESPONSES : ");
		return responseJSP;
	}
	
}
