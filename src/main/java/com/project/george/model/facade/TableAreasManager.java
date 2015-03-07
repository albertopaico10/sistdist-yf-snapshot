package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbArea;
import com.project.george.model.TbRole;
import com.project.george.model.dto.TbAreasDTO;

public interface TableAreasManager {
	List<TbAreasDTO> listAllAreas() throws Exception;
	String addNewArea(TbArea tbAreaBean)throws Exception;
	String deleteArea(int idArea) throws Exception;
}
