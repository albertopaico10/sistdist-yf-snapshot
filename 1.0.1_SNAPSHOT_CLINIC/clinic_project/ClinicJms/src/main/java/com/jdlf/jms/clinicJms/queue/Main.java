package com.jdlf.jms.clinicJms.queue;

public class Main {
	
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		receiver.receiveQueue();
	}

}
