package com.project.george.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.project.george.common.CommonUtil;
import com.project.george.model.TbArea;
import com.project.george.model.TbPresentation;
import com.project.george.model.dto.TbAreasDTO;
import com.project.george.model.dto.TbPresentationDTO;
import com.project.george.model.facade.TableAreasManager;
import com.project.george.model.facade.TablePresentationManager;

@Controller
public class ManteniencePresentationController {
	
	@Autowired
	TablePresentationManager tablePresentationMan;
	
	@RequestMapping("listPresentation.htm")
    public ModelAndView listMaintenancePresentation (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside listMaintenancePresentation htm");
		final TbPresentation tablePresentation=new TbPresentation();
		model.addAttribute("maintenancePresentationForm", tablePresentation);
		
		String responseStr=CommonUtil.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION;
		
		try {
			List<TbPresentationDTO> listAllPresentation=tablePresentationMan.listAllPresentation();
			System.out.println("Cantidad de filas que trae :"+listAllPresentation.size());
			request.setAttribute("listPresentation", listAllPresentation);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(responseStr);
	}
	
	@RequestMapping("registerPresentation.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute TbPresentation tablePresentationBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside registerPresentation htm");
		String valueResponse="";
		try {
			valueResponse=tablePresentationMan.addNewPresentation(tablePresentationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	
	@RequestMapping("deleteMaintenancePresentation.htm")
    public String deletePresentation(final ModelMap model,final SessionStatus status,
            final HttpServletRequest request) {
		System.out.println("inside deletePresentation.htm");
		final int idPresentation = Integer.parseInt(request.getParameter("idPresentation"));
		System.out.println("ID Presentation : "+idPresentation);
		String valueResponse="";
		try {
			valueResponse=tablePresentationMan.deletePresentation(idPresentation);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		} 
		return valueResponse;
	}
	
	@RequestMapping("updatePresentation.htm")
	public ModelAndView updateAreaForm(
			@ModelAttribute TbPresentation tablePresentationBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside updateAreaForm htm");
		String valueResponse="";
		System.out.println("Change Name : "+tablePresentationBean.getNamePresentation()+"********"+tablePresentationBean.getId());
		try {
			valueResponse=tablePresentationMan.addNewPresentation(tablePresentationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
}
