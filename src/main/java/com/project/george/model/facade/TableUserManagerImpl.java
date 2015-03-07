package com.project.george.model.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbUser;
import com.project.george.model.dao.TableUserDao;
import com.project.george.model.dto.TbUserDTO;

@Service
@Transactional
public class TableUserManagerImpl implements TableUserManager {

	@Autowired
	TableUserDao customTableUser;

	public TbUserDTO validateUserAndPassword(String user, String pass)
			throws Exception {
		System.out.println("Inside de Manager validateUserAndPassword");
		String newPass=UtilMethods.getStringMessageDigest(pass, CommonUtil.Login.ALGORITHM_MD5);
		System.out.println("New password : "+newPass);
		List<TbUser> listTbUserByParam = customTableUser.validateUserAndPass(
				user, newPass);
		TbUserDTO tbUserDto = new TbUserDTO();
		UtilMethods utilMethods=new UtilMethods();
		
		if (!(listTbUserByParam.size()>0)) {
			tbUserDto.setResponse(CommonUtil.Login.RESPONSE_LOGIN_INCORRECT);
		} else {
			for (TbUser userBean : listTbUserByParam) {
				tbUserDto=utilMethods.copyValuesUserDTO(userBean, tbUserDto);
				UtilMethods util=new UtilMethods();
				userBean.setLastLoginDate(util.getCurrentDate());
				tbUserDto.setResponse(CommonUtil.Login.RESPONSE_LOGIN_CORRECT);
				customTableUser.updateLastLogin(userBean);
			}
//			TbUser beanUser=customTableUser.beanSpecific(user);
//			beanUser
		}
		return tbUserDto;
	}

}
