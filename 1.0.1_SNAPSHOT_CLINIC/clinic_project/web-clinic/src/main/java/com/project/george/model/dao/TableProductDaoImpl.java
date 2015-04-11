package com.project.george.model.dao;

import java.util.List;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbProduct;

@Repository
public class TableProductDaoImpl implements TableProductDao {
	
	@Autowired
	SessionFactory sessionfactory;
		
	public List<TbProduct> listSpecificProduct(String nameProduct) {
		String query="from TbProduct where status=1 and nameProduct like '%"+nameProduct+"%'";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbProduct> listQuery=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listQuery.size());
		
		session.close();
		
		return listQuery;
		
	}
	
	public List<TbProduct> listAllTypeProduct() {
		String query="from TbProduct where status=1";
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbProduct> listQuery=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listQuery.size());
		
		session.close();
		
		return listQuery;
	}
	
	public void addNewMantenience(TbProduct tbTypeProductBean) {
		tbTypeProductBean.setStatus(1);
		sessionfactory.getCurrentSession().saveOrUpdate(tbTypeProductBean);			
	}
	
	public TbProduct beanProductSpecific(int idValue) {
		String query="from TbProduct where status=1 and id='"+idValue+"'";
		System.out.println("query : "+query);
		Session session=sessionfactory.openSession();
		
		List<TbProduct> listSpecificById=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listSpecificById.size());
		
		session.close();
				
		return listSpecificById.get(0);
	}
		
	public void deleteValueMantenience(TbProduct tbProductBean) {
		sessionfactory.getCurrentSession().saveOrUpdate(tbProductBean);
	}

	public List<TbProduct> listSpecificProductById(String idProduct) {
		String query="from TbProduct where status=1 and id="+idProduct;
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbProduct> listQuery=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+listQuery.size());
		
		session.close();
		
		return listQuery;
	}
	
	public void updateProduct(TbProduct tbTypeProductBean) {
		tbTypeProductBean.setNameProduct(tbTypeProductBean.getNameProduct());
		//tbTypeProductBean.setTbPresentation(tbPresentation.);(tbTypeProductBean.getTbPresentation().getId());
		tbTypeProductBean.setPrice_Product(tbTypeProductBean.getPrice_Product());
		tbTypeProductBean.setPrice_sale(tbTypeProductBean.getPrice_sale());
	//	tbTypeProductBean.setExpirationDate(util.convertDateFormat(tbTypeProductBean.getExpirationDate()));
		
		sessionfactory.getCurrentSession().saveOrUpdate(tbTypeProductBean);			
	}

}
