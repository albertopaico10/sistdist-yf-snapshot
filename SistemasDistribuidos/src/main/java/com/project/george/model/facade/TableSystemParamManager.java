package com.project.george.model.facade;

import com.project.george.model.TbSystemParam;

public interface TableSystemParamManager {
	TbSystemParam getValueSystemParam(String nameParam);
	void updateSystemParam(TbSystemParam tbSystemParamBean);
}
