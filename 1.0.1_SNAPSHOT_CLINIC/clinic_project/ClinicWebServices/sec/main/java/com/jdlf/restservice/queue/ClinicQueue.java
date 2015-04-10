package com.jdlf.restservice.queue;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.jdlf.restservice.model.Paciente;

public class ClinicQueue {

    private static ConnectionFactory factory = null;
    private static Connection connection = null;
    private static Session session = null;
    private static Destination destination = null;
    private static MessageProducer producer = null;

    public ClinicQueue() {

    }

    public static void sendPaciente(Paciente paciente) {

        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("CLINIC_QUEUE_PACIENTES_TO_CREATE");
            producer = session.createProducer(destination);
            ObjectMessage message =  session.createObjectMessage();
            message.setObject(paciente);
            producer.send(message);
            System.out.println("Sent: "+paciente.toString());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
