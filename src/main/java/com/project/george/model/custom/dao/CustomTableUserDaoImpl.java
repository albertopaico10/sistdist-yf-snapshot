package com.project.george.model.custom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbUser;
import com.project.george.model.dao.TableUserDaoImpl;

public class CustomTableUserDaoImpl  implements
		CustomTableUserDao {
	

//	public List<TbUser> validateUserAndPass(String user, String pass) {
//		System.out.println("validateUserAndPass CustomTableUserDaoImpl");
//		List<TbUser> tbUserList = null;
//
//		String query = "select count(*) from TbUser where UPPER(userName) = ? and password = ?";
//		try {
//			tbUserList = find(TbUser.class, query, user, pass);
//		} catch (Exception e) {
//			System.out.println("Error : " + e.toString() + e);
//		}
//		return tbUserList;
//	}

}
