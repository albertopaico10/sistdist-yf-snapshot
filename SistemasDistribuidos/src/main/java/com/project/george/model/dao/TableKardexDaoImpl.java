package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbKardex;

@Repository
public class TableKardexDaoImpl implements TableKardexDao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public List<TbKardex> listKardexByProduct(int idProduct){
		String query="from TbKardex where status=1 and idProduct="+idProduct;
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbKardex> kardexList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+kardexList.size());
		
		session.close();
		
		return kardexList;
		
	}
	
	public int addNewKardex(TbKardex tbKardexBean)throws Exception{	
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(tbKardexBean);
		System.out.println("Last ID : "+tbKardexBean.getId());
		
		transaction.commit();
		session.close();
		return tbKardexBean.getId();
	}

	public int updateKardex(TbKardex tbKardexBean) throws Exception {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.update(tbKardexBean);
		System.out.println("Last ID : "+tbKardexBean.getId());
		
		transaction.commit();
		session.close();
		return 0;
	}
	
	public void updateSQL(TbKardex tbKardexBean){
		Session session = sessionfactory.openSession();
		String querySQL="update tb_kardex set countProduct='"+tbKardexBean.getCountProduct()+"', total_entry='"+tbKardexBean.getTotalEntry()+"', total_egress='"+tbKardexBean.getTotalEgress()+"', priceTotalProduct='"+tbKardexBean.getPriceTotalProduct()+"', priceTotalSale='"+tbKardexBean.getPriceTotalSale()+"' where id="+tbKardexBean.getId();
		System.out.println("QUERY : " + querySQL);
	
		session.getTransaction().begin();
		Query query = session.createSQLQuery(querySQL);
		int result = query.executeUpdate();
		System.out.println("Filas afectadas : " + result);
		session.getTransaction().commit();

		session.close();
		
	}

	public List<TbKardex> listStockProduct(String idKardex) {
		String query="from TbKardex where status=1 and id="+idKardex;
		System.out.println("query : "+query);
		
		Session session=sessionfactory.openSession();
		
		List<TbKardex> kardexList=session.createQuery(query).list();
		System.out.println("Cantidad de filas : "+kardexList.size());
		
		session.close();
		
		return kardexList;
	}
	
	
	
}
