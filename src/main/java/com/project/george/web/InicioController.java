package com.project.george.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

	@RequestMapping("inicio.htm")
    public ModelAndView show(final HttpServletRequest request) {
		System.out.println("inside inicio htm");
		return new ModelAndView("redirect:logueo.htm"); 
	}
}
