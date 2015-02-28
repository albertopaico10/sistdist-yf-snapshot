package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbPresentation;
import com.project.george.model.dto.TbPresentationDTO;

public interface TablePresentationManager {
	List<TbPresentationDTO> listAllPresentation() throws Exception;
	String addNewPresentation(TbPresentation tbPresentationBean) throws Exception;
	String deletePresentation(int idPresentation) throws Exception;
}
