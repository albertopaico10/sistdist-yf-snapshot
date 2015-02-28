package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;

public interface ResponseUtilManager {
	public String responsesKardex(List<TbKardexDTO> beanKardexDTO)throws Exception;
	public String responsesDetailKardex(List<TbDetailKardexDTO> beanKardexDTO)throws Exception;

}
