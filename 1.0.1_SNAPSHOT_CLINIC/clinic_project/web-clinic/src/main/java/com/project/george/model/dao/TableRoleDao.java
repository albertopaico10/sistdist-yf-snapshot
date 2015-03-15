package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbRole;

public interface TableRoleDao {
	
	List<TbRole> listAllRole();
	void addNewRole(TbRole tbRoleBean);
	void deleteRole(TbRole tbRoleBean); 
}
