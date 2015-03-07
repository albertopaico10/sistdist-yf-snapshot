package com.project.george.model.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.model.TbSystemParam;
import com.project.george.model.dao.TableSystemParamDao;

@Service
@Transactional
public class TableSystemManagerImpl implements TableSystemParamManager {
	
	@Autowired
	TableSystemParamDao custmTableSystemParam;
	
	public TbSystemParam getValueSystemParam(String nameParam) {
		TbSystemParam beanSytemParam=custmTableSystemParam.beanSystemParamSpecific(nameParam);
		return beanSytemParam;
	}

	public void updateSystemParam(TbSystemParam tbSystemParamBean) {
		custmTableSystemParam.updateSystemParam(tbSystemParamBean);		
	}
	
	

}
