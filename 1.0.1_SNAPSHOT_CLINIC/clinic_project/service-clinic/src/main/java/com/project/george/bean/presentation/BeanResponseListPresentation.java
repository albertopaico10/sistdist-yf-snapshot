package com.project.george.bean.presentation;

import java.util.List;

import com.project.george.bean.presentation.canonical.BeanResponseCanonicalPresentation;

public class BeanResponseListPresentation {
	public List<BeanResponseCanonicalPresentation> beanListPresentation;
	public String result;

	public List<BeanResponseCanonicalPresentation> getBeanListPresentation() {
		return beanListPresentation;
	}

	public void setBeanListPresentation(
			List<BeanResponseCanonicalPresentation> beanListPresentation) {
		this.beanListPresentation = beanListPresentation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
