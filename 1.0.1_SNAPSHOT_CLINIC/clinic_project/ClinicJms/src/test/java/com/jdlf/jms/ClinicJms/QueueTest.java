package com.jdlf.jms.ClinicJms;

import java.sql.Timestamp;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import junit.framework.Assert;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import com.jdlf.jms.clinicJms.queue.Receiver;
import com.jdlf.restservice.model.Paciente;

public class QueueTest {
	
	
	private ActiveMQConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Queue destination;
	private MessageProducer producer;
	Date date = new Date();
	
	@Test
	public void recievePacienteToQueue(){
		sendPacienteToQueue();
		
		Receiver receiver = new Receiver();		
		boolean result = receiver.receiveQueue();
		Assert.assertTrue(result);
	}
    
	public void sendPacienteToQueue(){
		 try {
	            factory = new ActiveMQConnectionFactory(
	                    ActiveMQConnection.DEFAULT_BROKER_URL);
	            connection = factory.createConnection();
	            connection.start();
	            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            destination = session.createQueue("CLINIC_QUEUE_PACIENTES_TO_CREATE");
	            producer = session.createProducer(destination);
	            ObjectMessage message =  session.createObjectMessage();
	            
	            Paciente paciente = new Paciente();
	    		paciente.setNamePatient("diegoLF");
	    		paciente.setLastNamePatient("diegoLN");
	    		paciente.setDni("6666668");
	    		paciente.setBirthDay(new Date());
	    		paciente.setDateCreated(new Timestamp(date.getTime()));
	    		paciente.setDateUpdated(new Timestamp(date.getTime()));
	            
	            message.setObject(paciente);
	            producer.send(message);
	            System.out.println("Sent: "+paciente.toString());

	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	}
}
