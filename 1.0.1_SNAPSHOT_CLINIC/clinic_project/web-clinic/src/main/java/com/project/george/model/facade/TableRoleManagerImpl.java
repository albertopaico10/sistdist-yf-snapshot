package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonConstants;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbRole;
import com.project.george.model.dao.TableRoleDao;
import com.project.george.model.dto.TbRoleDTO;

@Service
@Transactional
public class TableRoleManagerImpl implements TableRoleManager{
	
	@Autowired
	TableRoleDao customTableRole;
	
	public List<TbRoleDTO> listAllRoles() throws Exception {
		System.out.println("Inside listAllRoles");
		List<TbRole> listAllRole=customTableRole.listAllRole();
		
		List<TbRoleDTO> newListAllRole=new ArrayList<TbRoleDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for(TbRole beanRole:listAllRole){
			TbRoleDTO beanRoleDTO=new TbRoleDTO();			
			beanRoleDTO=utilMethods.copyValuesRoleDTO(beanRole, beanRoleDTO);			
			newListAllRole.add(beanRoleDTO);
		}
		return newListAllRole;
	}

	public String addNewRole(TbRole tbRoleBean) throws Exception {
		String returnRsponse=CommonConstants.MantenienceRoles.RESPONSE_MANTENIENCE_ROLE_NEW;
		try {
			customTableRole.addNewRole(tbRoleBean);
		} catch (Exception e) {
			returnRsponse=CommonConstants.ERROR;
		}
		return returnRsponse;
	}
	
	
	public String deleteRole(int idRole) throws Exception {
		String returnRsponse=CommonConstants.MantenienceRoles.RESPONSE_MANTENIENCE_ROLE_NEW;
		TbRole tbRoleBean=new TbRole();
		tbRoleBean.setId(idRole);
		tbRoleBean.setStatus(2);//--2 is Inactive
		customTableRole.deleteRole(tbRoleBean);
		return returnRsponse;
	}

}
