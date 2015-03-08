package com.project.george.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CloseSessionController {

	
	@RequestMapping("closeSession.htm")
    public ModelAndView close(final HttpServletRequest request) {
		System.out.println("inside closeSession htm");
		return new ModelAndView("redirect:logueo.htm"); 
	}
}
