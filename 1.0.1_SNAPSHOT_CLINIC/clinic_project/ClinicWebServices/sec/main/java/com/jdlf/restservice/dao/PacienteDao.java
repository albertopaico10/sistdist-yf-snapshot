 package com.jdlf.restservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.jdlf.restservice.model.Paciente;

public class PacienteDao implements PacienteDaoInterface<Paciente, Integer> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public PacienteDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	
	public Paciente persist(Paciente entity) {
		 getCurrentSession().save(entity);
		 return entity;
	}

	public Paciente update(Paciente entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	
	public Paciente findById(Integer id) {
		Paciente book = (Paciente) getCurrentSession().get(Paciente.class, id);
		return book; 
	}

	
	public void delete(Paciente entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> findAll() {
		List<Paciente> books = (List<Paciente>) getCurrentSession().createQuery("from Paciente").list();
		return books;
	}

	public void deleteAll() {
		List<Paciente> entityList = findAll();
		for (Paciente entity : entityList) {
			delete(entity);
		}
	}
}