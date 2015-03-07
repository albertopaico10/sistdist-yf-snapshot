package com.project.george.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.george.model.TbDetailKardex;
import com.project.george.model.TbKardex;
import com.project.george.model.TbProduct;

@Repository
public class TableDetailKardexDaoImpl implements TableDetailKardexDao {

	@Autowired
	SessionFactory sessionfactory;

	public List<TbDetailKardex> listDetailKardexByKardexId(int idKardex)
			throws Exception {
		String query = "from TbDetailKardex where status=1 and idKardex="
				+ idKardex;
		System.out.println("query : " + query);

		Session session = sessionfactory.openSession();
		// session.flush();
		// session.clear();
		List<TbDetailKardex> detilKardexList = session.createQuery(query).list();
		System.out.println("Cantidad de filas : " + detilKardexList.size());

		session.close();

		return detilKardexList;
	}

	public void addNewDetailKardex(TbDetailKardex tbDetailKardexBean) {
		Session session = sessionfactory.openSession();
		// Transaction transaction=session.beginTransaction();
		// tbDetailKardexBean.setStatus(1);
		// session.saveOrUpdate(tbDetailKardexBean);
		// transaction.commit();

		String sql = "insert into Tb_detail_Kardex (id,idKardex,cantidad,typeOperation,comprobante_clase,comprobante_number,status,price_Product,price_sale) values ('0','"
				+ tbDetailKardexBean.getTbKardex().getId()
				+ "','"
				+ tbDetailKardexBean.getCantidad()
				+ "','"
				+ tbDetailKardexBean.getTypeOperation()
				+ "','"
				+ tbDetailKardexBean.getComprobante_clase()
				+ "','"
				+ tbDetailKardexBean.getComprobante_number()
				+ "','"
				+ tbDetailKardexBean.getStatus()
				+ "','"
				+ tbDetailKardexBean.getPrice_Product()
				+ "','"
				+ tbDetailKardexBean.getPrice_sale() + "')";
		System.out.println("QUERY : " + sql);

		session.getTransaction().begin();
		Query query = session.createSQLQuery(sql);
		int result = query.executeUpdate();
		System.out.println("Filas afectadas : " + result);
		session.getTransaction().commit();

		session.close();
	}

	public void addNew_DetailKardex(TbDetailKardex tbDetailKardexBean){

		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(tbDetailKardexBean);
		System.out.println("Last ID Detail: " + tbDetailKardexBean.getId());

		transaction.commit();
		session.close();
//		return tbKardexBean.getId();
	}
}
