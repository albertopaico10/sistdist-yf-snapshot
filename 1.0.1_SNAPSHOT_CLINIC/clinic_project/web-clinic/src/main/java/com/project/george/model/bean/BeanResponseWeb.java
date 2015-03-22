package com.project.george.model.bean;

import java.util.List;

import com.project.george.model.dto.PresentationDTO;

public class BeanResponseWeb {
	public String redirectTo;
	public String statusResponse;
	public String message;
	public List<PresentationDTO> listPresentationDTO;
	
	public String getRedirectTo() {
		return redirectTo;
	}
	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusResponse() {
		return statusResponse;
	}
	public void setStatusResponse(String statusResponse) {
		this.statusResponse = statusResponse;
	}
	public List<PresentationDTO> getListPresentationDTO() {
		return listPresentationDTO;
	}
	public void setListPresentationDTO(List<PresentationDTO> listPresentationDTO) {
		this.listPresentationDTO = listPresentationDTO;
	}
}
