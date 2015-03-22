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

import com.project.george.common.CommonConstants;
import com.project.george.model.TbRole;
import com.project.george.model.TbUser;
import com.project.george.model.dto.TbRoleDTO;
import com.project.george.model.facade.TableRoleManager;

@Controller
public class MantenienceRolesController {

	@Autowired
	TableRoleManager tableRoleMan;
	
	@RequestMapping("mantenienceRoles22.htm")
    public String show(final ModelMap model) {
		System.out.println("inside mantenienceRoles htm");
		final TbRole tableRole=new TbRole();
		model.addAttribute("maintenanceRoleForm", tableRole);
		return CommonConstants.MantenienceRoles.RESPONSE_MANTENIENCE_ROLE; 
	}
	
	
	@RequestMapping("listMaintenanceRoles.htm")
    public ModelAndView listMaintenanceRole (HttpServletRequest request,
			HttpServletResponse response,final ModelMap model) {
		System.out.println("inside listMaintenanceRole htm");
		
		final TbRole tableRole=new TbRole();
		model.addAttribute("maintenanceRoleForm", tableRole);
		
		String responseStr=CommonConstants.MantenienceRoles.RESPONSE_MANTENIENCE_ROLE;
		try {
			List<TbRoleDTO> listAllRole=tableRoleMan.listAllRoles();
			System.out.println("Cantidad de filas que trae :"+listAllRole.size());
			request.setAttribute("listRole", listAllRole);
		} catch (Exception e) {
			responseStr=CommonConstants.ERROR;
		}
		return new ModelAndView(responseStr); 
	}
	
	
	@RequestMapping("registerRole.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute TbRole tableRoleBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside registerRole htm");
		String valueResponse="";
		try {
			valueResponse=tableRoleMan.addNewRole(tableRoleBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	
	@RequestMapping("deleteMaintenanceRole.htm")
    public String deleteRole(final ModelMap model,final SessionStatus status,
            final HttpServletRequest request) {
		System.out.println("inside deleteRole.htm");
		final int idRole = Integer.parseInt(request.getParameter("idRole"));
		System.out.println("ID Role : "+idRole);
		String valueResponse="";
		try {
			valueResponse=tableRoleMan.deleteRole(idRole);
		} catch (Exception e) {
			System.out.println("Erro : "+e.toString());
		} 
		return valueResponse;
	}
	
	@RequestMapping("updateRole.htm")
	public ModelAndView updateRolForm(
			@ModelAttribute TbRole tableRoleBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request) {
		System.out.println("inside updateRolForm htm");
		String valueResponse="";
		System.out.println("Change Name : "+tableRoleBean.getNombreRole()+"********"+tableRoleBean.getId());
		try {
			valueResponse=tableRoleMan.addNewRole(tableRoleBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**** "+valueResponse);
		System.out.println("Save User Data");
		return new ModelAndView(valueResponse);
	}
	
	
}
