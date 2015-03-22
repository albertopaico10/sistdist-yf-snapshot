package com.project.george.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.project.george.common.CommonConstants;
import com.project.george.facade.service.impl.ProductServiceImpl;
import com.project.george.model.TbArea;
import com.project.george.model.TbPresentation;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dto.TbAreasDTO;
import com.project.george.model.dto.PresentationDTO;
import com.project.george.model.facade.TableAreasManager;
import com.project.george.model.facade.TablePresentationManager;

@Controller
public class ManteniencePresentationController {
	private static Logger logger = Logger.getLogger(ManteniencePresentationController.class);
	@Autowired
	TablePresentationManager tablePresentationMan;
	
	@RequestMapping("listPresentation.htm")
    public ModelAndView listMaintenancePresentation (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside listMaintenancePresentation htm");
		final PresentationDTO tablePresentation=new PresentationDTO();
		model.addAttribute("maintenancePresentationForm", tablePresentation);
		
		String responseStr=CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION;
		
		try {
			//--List presentation
			List<PresentationDTO> listAllPresentation=tablePresentationMan.listPresentationComplete();
			System.out.println("Cantidad de filas que trae :"+listAllPresentation.size());
			request.setAttribute("listPresentation", listAllPresentation);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(responseStr);
	}
	
	@RequestMapping("registerPresentation.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute PresentationDTO beanPresentationDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("inside registerPresentation htm");
		logger.info(CommonConstants.Logger.LOGGER_START);
		String valueResponse="";
		try {
			BeanResponseWeb beanResponseWeb=tablePresentationMan.insertNewPresentation(beanPresentationDTO);
			valueResponse=beanResponseWeb.getRedirectTo();
			System.out.println("**********RETORNO DE MENSAJE :"+beanResponseWeb.getStatusResponse());
			request.setAttribute("messages", beanResponseWeb.getStatusResponse());
			model.addAttribute("maintenancePresentationForm", beanPresentationDTO);
			//--List Presentation
			request.setAttribute("listPresentation", beanResponseWeb.getListPresentationDTO());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		System.out.println("**** "+valueResponse);
		logger.info(CommonConstants.Logger.LOGGER_START);
		return new ModelAndView(valueResponse);
	}
	
	
	@RequestMapping("deleteMaintenancePresentation.htm")
    public String deletePresentation(final ModelMap model,final SessionStatus status,
            final HttpServletRequest request) {
		System.out.println("inside deletePresentation.htm");
		final int idPresentation = Integer.parseInt(request.getParameter("idPresentation"));
		System.out.println("ID Presentation : "+idPresentation);
		String valueResponse="";
		BeanResponseWeb beanResponseWeb=new BeanResponseWeb();
		try {
//			valueResponse=tablePresentationMan.deletePresentation(idPresentation);
			beanResponseWeb=tablePresentationMan.deletePresentationWS(idPresentation);
			request.setAttribute("messages", beanResponseWeb.getStatusResponse());
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		} 
		return beanResponseWeb.getRedirectTo();
	}
	
	@RequestMapping("updatePresentation.htm")
	public ModelAndView updateAreaForm(
			@ModelAttribute PresentationDTO beanPresentationDTO,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("inside updateAreaForm htm");
		String valueResponse="";
		System.out.println("Change Name : "+beanPresentationDTO.getNamePresentation()+"********"+beanPresentationDTO.getId());
		try {
			BeanResponseWeb beanResponseWeb=tablePresentationMan.updatePresentation(beanPresentationDTO);
			valueResponse=beanResponseWeb.getRedirectTo();
			System.out.println("**********RETORNO DE MENSAJE :"+beanResponseWeb.getStatusResponse());
			request.setAttribute("messages", beanResponseWeb.getStatusResponse());
			model.addAttribute("maintenancePresentationForm", beanPresentationDTO);
			//--List Presentation
			request.setAttribute("listPresentation", beanResponseWeb.getListPresentationDTO());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
}
