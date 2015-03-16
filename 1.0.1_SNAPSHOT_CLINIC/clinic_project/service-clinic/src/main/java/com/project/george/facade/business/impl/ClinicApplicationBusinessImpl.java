package com.project.george.facade.business.impl;

import org.springframework.stereotype.Service;

import com.project.george.facade.business.ClinicApplicationBusiness;

@Service
public class ClinicApplicationBusinessImpl implements ClinicApplicationBusiness {

	public String mensajeTest(String value) throws Exception {

		return "HOLA .... "+value;
	}

}
