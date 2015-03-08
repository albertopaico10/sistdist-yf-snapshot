package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbArea;
import com.project.george.model.TbRole;

public interface TableAreaDao {
	List<TbArea> listAllAreas();
	void addNewArea(TbArea tbAreaBean);
	void deleteArea(TbArea tbAreaBean);
	TbArea beanAreaSpecific(int idArea);
}
