package com.project.george.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.george.facade.business.ClinicApplicationBusiness;

@Controller
public class InicioController {
	
	@Autowired
	public ClinicApplicationBusiness clinicApplicationBusiness;
	
	@RequestMapping("inicio.htm")
    public ModelAndView show(final HttpServletRequest request) {
		System.out.println("inside inicio htm");
		try {
			System.out.println("Ready...??");
			String value=clinicApplicationBusiness.mensajeTest("Carlos");
			System.out.println("**** "+value);
		} catch (Exception e) {
			System.out.println("Error : "+e.toString());
		}
		return new ModelAndView("redirect:logueo.htm"); 
	}
}
