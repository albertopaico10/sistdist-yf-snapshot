package com.project.george.model.facade;

import com.project.george.model.dto.TbUserDTO;

public interface TableUserManager {

	TbUserDTO validateUserAndPassword(String user,String pass)throws Exception;
	
}
