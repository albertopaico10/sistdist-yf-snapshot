package com.project.george.model.dao;

import com.project.george.model.TbSystemParam;

public interface TableSystemParamDao {
	TbSystemParam beanSystemParamSpecific(String nameParam);
	void updateSystemParam(TbSystemParam tbSystemParamBean);
	
}
