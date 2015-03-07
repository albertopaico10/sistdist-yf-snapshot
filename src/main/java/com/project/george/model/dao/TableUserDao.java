package com.project.george.model.dao;

import java.util.List;

import com.project.george.model.TbUser;

public interface TableUserDao {
	
    List<TbUser> validateUserAndPass(String user, String pass);
    void updateLastLogin(TbUser tbUserBean);
    TbUser beanSpecific(String userName);
}
