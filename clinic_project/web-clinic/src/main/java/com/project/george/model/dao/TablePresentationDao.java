package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbArea;
import com.project.george.model.TbPresentation;

public interface TablePresentationDao {
	List<TbPresentation> listAllPresentation();
	void addNewPresentation(TbPresentation tbPresentationBean);
	TbPresentation beanPresentationSpecific(int idPresentation);
	 void deletePresentation(TbPresentation tbPresentationBean);
}
