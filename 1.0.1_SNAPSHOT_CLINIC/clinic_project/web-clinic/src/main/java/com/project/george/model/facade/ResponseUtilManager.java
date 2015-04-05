package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.dto.DetailKardexDTO;
import com.project.george.model.dto.KardexDTO;

public interface ResponseUtilManager {
	public String responsesKardex(List<KardexDTO> beanKardexDTO)throws Exception;
	public String responsesDetailKardex(List<DetailKardexDTO> beanKardexDTO)throws Exception;

}
