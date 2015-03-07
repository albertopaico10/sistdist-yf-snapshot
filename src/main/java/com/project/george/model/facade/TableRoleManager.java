package com.project.george.model.facade;

import java.util.List;

import com.project.george.model.TbRole;
import com.project.george.model.dto.TbRoleDTO;

public interface TableRoleManager {
	
	List<TbRoleDTO> listAllRoles()throws Exception;
	String addNewRole(TbRole tbRoleBean)throws Exception;
	String deleteRole(int idRole) throws Exception;
}
