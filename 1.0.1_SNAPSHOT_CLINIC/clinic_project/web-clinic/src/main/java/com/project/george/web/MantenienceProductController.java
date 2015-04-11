package com.project.george.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.george.common.CommonConstants;
import com.project.george.model.TbProduct;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.bean.PatientJson;
import com.project.george.model.dto.PresentationDTO;
import com.project.george.model.dto.ProductDTO;
import com.project.george.model.facade.TablePresentationManager;
import com.project.george.model.facade.TableProductManager;

@Controller
public class MantenienceProductController {
	
	@Autowired
	TableProductManager tableProduct;
	@Autowired
	TablePresentationManager tablePresentationMan;
	
	@RequestMapping("listProduct.htm")
    public ModelAndView listMantenienceTypeProduct (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside listMantenienceTypeProduct htm");
		final ProductDTO tbTypeProduct=new ProductDTO();
		model.addAttribute("maintenanceForm", tbTypeProduct);
		
		String responseStr=CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT;
		
		try {
//			List<ProductDTO> listAllTypeProduct=tableProduct.listAllTypeProduct();
			List<ProductDTO> listAllTypeProduct=tableProduct.listProduct();
			System.out.println("Cantidad de filas que trae :"+listAllTypeProduct.size());
			request.setAttribute("listTypeProduct", listAllTypeProduct);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(responseStr);
	}
	
	@ModelAttribute("listAllPresentation")
  public final List<PresentationDTO> presentationList(
          final HttpServletRequest request) {
		try {
			BeanResponseWeb listAllPresentation=tablePresentationMan.listPresentationComplete();
			System.out.println("Cantidad de areas  para cargar:"+listAllPresentation.getListPresentationDTO().size());
			return listAllPresentation.getListPresentationDTO();
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		return null;
	}
	
	@RequestMapping("registerProduct.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute ProductDTO beanProductDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside registerTypeProduct htm");
		BeanResponseWeb valueResponse=null;
		try {
			valueResponse=tableProduct.saveProduct(beanProductDTO);
//			valueResponse=tableProduct.addNewTypeProduct(beanProductDTO);
//			BeanProduct responseProduct=tableProduct.saveProduct(beanProductDTO);
			if(CommonConstants.MantenienceProduct.RESPONSE_MANTENIENCE_PRODUCT_NEW.equals(valueResponse.getStatusResponse())){				
				request.setAttribute("messages", "success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse.getStatusResponse());
		System.out.println("Save Product");
		return new ModelAndView(valueResponse.getStatusResponse());
	}
	
	@RequestMapping("updateProduct.htm")
	public ModelAndView updateAreaForm(
			@ModelAttribute TbProduct tableTypeProductBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside updateAreaForm htm");
		String valueResponse="";
		System.out.println("Change Name : "+tableTypeProductBean.getNameProduct()+"********"+tableTypeProductBean.getId());
		try {
			valueResponse=tableProduct.addNewTypeProduct(tableTypeProductBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	@RequestMapping("deleteMaintenanceProduct.htm")
    public String deleteArea(final ModelMap model,final SessionStatus status,
            final HttpServletRequest request) {
		System.out.println("inside deleteMaintenanceArea.htm");
		final int idTypeProduct = Integer.parseInt(request.getParameter("idProduct"));
		System.out.println("ID Type Product : "+idTypeProduct);
		String valueResponse="";
		try {
			valueResponse=tableProduct.deleteTypeProduct(idTypeProduct);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		} 
		return valueResponse;
	}
	
	@RequestMapping(value = "/listAllProductJson.htm", 
		    method = RequestMethod.GET, produces = 
		    "application/json")
	    public @ResponseBody String springPaginationDataTables() 
		    throws IOException {
		System.out.println("Entre a listar todos los productos");
		String json2="";
		try {
//			List<ProductDTO> listAllProduct=tableProduct.listAllTypeProduct();
			List<ProductDTO> listAllProduct=tableProduct.listProduct();
			PatientJson beanPatientJson=new PatientJson();
			beanPatientJson.setiTotalDisplayRecords(listAllProduct.size());
			beanPatientJson.setiTotalRecords(listAllProduct.size());
			beanPatientJson.setProductData(listAllProduct);
			
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			json2=gson.toJson(beanPatientJson);
			
			
			System.out.println("Cantidad de filas que trae : "+listAllProduct.size());
//			request.setAttribute("listPatient", listAllPatient);
//			request.setAttribute("jsonTable", json2);
		} catch (Exception e) {
			System.out.println("Error :"+e.toString());
		}		
		return json2;
	}
	
}
