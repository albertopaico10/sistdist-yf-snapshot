package com.project.george.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.project.george.common.CommonUtil;
import com.project.george.model.TbUser;
import com.project.george.model.dto.TbUserDTO;
import com.project.george.model.facade.TableUserManager;


@Controller
public class LogueoController {
	
	@Autowired
	TableUserManager tableUserMan;
	
	@RequestMapping("validateUser.htm")
	public ModelAndView validateUserForm(
			@ModelAttribute TbUser tableUserBean,
			final BindingResult result, final SessionStatus status,
			final HttpServletRequest request,final ModelMap model) {
		System.out.println("Dentro de ValidateUserForm");
		System.out.println("Datos : "+tableUserBean.getUserName()+" *** "+tableUserBean.getPassword());
		TbUserDTO response=new TbUserDTO();
		try {
			response=tableUserMan.validateUserAndPassword(tableUserBean.getUserName(), tableUserBean.getPassword());
			if(!CommonUtil.Login.RESPONSE_LOGIN_CORRECT.equals(response.getResponse())){
				System.out.println("Dentro de responder Mensaje Incorrcto");
				final TbUser tableUser=new TbUser();
				model.addAttribute("loginUsuForm", tableUser);
				request.setAttribute("messages", "incorrect");
			}
			System.out.println("Response : "+response.getResponse());
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		return  new ModelAndView(response.getResponse(), "userObject", response);   
	}

	@RequestMapping("logueo.htm")
	public String initForm(final ModelMap model){
		System.out.println("initForm");
		
		final TbUser tableUser=new TbUser();
		model.addAttribute("loginUsuForm", tableUser);

		return CommonUtil.Login.RESPONS_LOGIN_OPEN;
	}

}
