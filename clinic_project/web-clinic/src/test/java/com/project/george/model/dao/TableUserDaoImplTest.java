package com.project.george.model.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.common.CommonUtil;
import com.project.george.common.UtilMethods;
import com.project.george.model.TbUser;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TableUserDaoImplTest {

	@Autowired
	TableUserDao tableUserDao;
	
	@Test
	public final void testvalidateUserAndPass(){
		System.out.println("Entreeee testvalidateUserAndPass");
		List<TbUser> listAllUser=tableUserDao.validateUserAndPass("jpaico", "c215b446bcdf956d848a8419c1b5a920");
		System.out.println("Cantidad de fila TEST : "+listAllUser.size());
		for(TbUser beanUser:listAllUser){
			System.out.println(beanUser.getNombreUsuario()+"||"+beanUser.getApellidoUsuario()+"||"+beanUser.getStatus());
		}
	}
	
	@Test
	public final void testbeanSpecific(){
		System.out.println("Entreeee testbeanSpecific");
		TbUser userBean=tableUserDao.beanSpecific("apaico");
		System.out.println("Datos : "+userBean.getApellidoUsuario()+"||"+userBean.getNombreUsuario()+"||"+userBean.getStatus()+"||"+userBean.getLastLoginDate());
		UtilMethods util=new UtilMethods();
		String formatDate=util.convertFormatString(userBean.getLastLoginDate(), CommonUtil.FormatDate.MM_DD_YYYY_HHMMSS);
		System.out.println("Formato final : "+formatDate);
	}
}
