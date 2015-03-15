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
import com.project.george.model.dto.TbAreasDTO;
import com.project.george.model.facade.TableAreasManager;

@Controller
public class MantenienceAreaController {
	
	@Autowired
	TableAreasManager tableAreaMan;

	@RequestMapping("listArea.htm")
    public ModelAndView listMaintenanceAreas (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside listMaintenanceAreas htm");
		final TbArea tableArea=new TbArea();
		model.addAttribute("maintenanceAreaForm", tableArea);
		
		String responseStr=CommonUtil.MantenienceArea.RESPONSE_MANTENIENCE_AREA;
		
		try {
			List<TbAreasDTO> listAllArea=tableAreaMan.listAllAreas();
			System.out.println("Cantidad de filas que trae :"+listAllArea.size());
			request.setAttribute("listArea", listAllArea);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		
		return new ModelAndView(responseStr);
	}	
	
	@RequestMapping("registerArea.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute TbArea tableAreaBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside registerArea htm");
		String valueResponse="";
		try {
			valueResponse=tableAreaMan.addNewArea(tableAreaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	
	@RequestMapping("updateArea.htm")
	public ModelAndView updateAreaForm(
			@ModelAttribute TbArea tableAreaBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside updateAreaForm htm");
		String valueResponse="";
		System.out.println("Change Name : "+tableAreaBean.getNameArea()+"********"+tableAreaBean.getId());
		try {
			valueResponse=tableAreaMan.addNewArea(tableAreaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	@RequestMapping("deleteMaintenanceArea.htm")
    public String deleteArea(final ModelMap model,final SessionStatus status,
            final HttpServletRequest request) {
		System.out.println("inside deleteMaintenanceArea.htm");
		final int idArea = Integer.parseInt(request.getParameter("idArea"));
		System.out.println("ID Role : "+idArea);
		String valueResponse="";
		try {
			valueResponse=tableAreaMan.deleteArea(idArea);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		} 
		return valueResponse;
	}
	
	
}
