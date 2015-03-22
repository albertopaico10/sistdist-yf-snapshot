package com.project.george.bean.catalog.presentation.canonical;

import java.util.List;

import com.project.george.bean.catalog.presentation.BeanResponsePresentation;

public class BeanListPresentation {
	List<BeanResponseCanonicalPresentation> response;

	public List<BeanResponseCanonicalPresentation> getResponse() {
		return response;
	}

	public void setResponse(List<BeanResponseCanonicalPresentation> response) {
		this.response = response;
	}

	
}
