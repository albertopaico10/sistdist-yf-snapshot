package com.project.george.model.bean;

import java.util.List;

import com.project.george.model.dto.DetailKardexDTO;
import com.project.george.model.dto.KardexDTO;
import com.project.george.model.dto.PresentationDTO;
import com.project.george.model.dto.ProductDTO;

public class BeanResponseWeb {
	public String redirectTo;
	public String statusResponse;
	public String message;
	public List<PresentationDTO> listPresentationDTO;
	public List<ProductDTO> listProductDTO;
	public List<KardexDTO> listKardexDTO;
	public List<DetailKardexDTO> listDetailKardexDTO;
	
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
	public List<ProductDTO> getListProductDTO() {
		return listProductDTO;
	}
	public void setListProductDTO(List<ProductDTO> listProductDTO) {
		this.listProductDTO = listProductDTO;
	}
	public List<KardexDTO> getListKardexDTO() {
		return listKardexDTO;
	}
	public void setListKardexDTO(List<KardexDTO> listKardexDTO) {
		this.listKardexDTO = listKardexDTO;
	}
	public List<DetailKardexDTO> getListDetailKardexDTO() {
		return listDetailKardexDTO;
	}
	public void setListDetailKardexDTO(List<DetailKardexDTO> listDetailKardexDTO) {
		this.listDetailKardexDTO = listDetailKardexDTO;
	}
	
}
