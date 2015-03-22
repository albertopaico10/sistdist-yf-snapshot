package com.project.george.util;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class UtilWebService {

	public static Call getCallService(String url) {

		Service servicio = new Service();

		System.out.println("se instancia el nuevo servicio");
		try {
			Call caller = (Call) servicio.createCall();
			caller.setTargetEndpointAddress(url);
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
