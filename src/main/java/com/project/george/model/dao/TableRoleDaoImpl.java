package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbRole;


@Repository
public class TableRoleDaoImpl implements TableRoleDao {
	
	@Autowired
	SessionFactory sessionfactory;

	public List<TbRole> listAllRole() {
		String query="from TbRole where status=1";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbRole> roleList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+roleList.size());
		
		session.close();
		
		return roleList;
	}

	public void addNewRole(TbRole tbRoleBean) {
		tbRoleBean.setStatus(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbRoleBean);
		
	}
	
	public void deleteRole(TbRole tbRoleBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbRoleBean);
	}

}
