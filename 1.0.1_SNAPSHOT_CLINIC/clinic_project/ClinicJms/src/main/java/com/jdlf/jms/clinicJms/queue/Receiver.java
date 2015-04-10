package com.jdlf.jms.clinicJms.queue;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import com.jdlf.jms.clinicJms.dao.PacienteDao;
import com.jdlf.restservice.model.Paciente;

public class Receiver {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;
    private static PacienteDao dao;

    public Receiver() {
    	dao = new PacienteDao();
    }

    public void receiveQueue() {
        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("CLINIC_QUEUE_PACIENTES_TO_CREATE");
            consumer = session.createConsumer(destination);
            
            Message message = consumer.receive();
            
            do{
            	
            	
            	if (message instanceof TextMessage) {
                    TextMessage text = (TextMessage) message;
                    System.out.println("Message is : " + text.getText());
                }
                if (message instanceof ActiveMQObjectMessage) {
                	ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
                	Paciente paciente = (Paciente)activeMQObjectMessage.getObject();
                	
                	dao.openCurrentSessionwithTransaction();
        			dao.persist(paciente);
        			dao.closeCurrentSessionwithTransaction();
        			
                    System.out.println("Paciente Saved : " + paciente.toString());
                }
                
                message = consumer.receive();
            }
            while(message!=null);
            
            

            
        } catch (JMSException e) {
                      e.printStackTrace();
        }
    }
}

