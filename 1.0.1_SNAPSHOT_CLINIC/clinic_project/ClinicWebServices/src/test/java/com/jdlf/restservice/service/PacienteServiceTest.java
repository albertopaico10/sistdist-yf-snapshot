package com.jdlf.restservice.service;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.jdlf.restservice.model.Paciente;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PacienteServiceTest {
	
	@Test
	public void testGetPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/get/3");
		 
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);
		System.out.println("response -> "+output);
		Assert.assertEquals("{\"id\":\"3\",\"namePatient\":\"Juan Luis\",\"lastNamePatient\":\"Perez\",\"dni\":\"76867867\"}", output);
		
		
	}
	
	@Test
	@Ignore
	public void testPostPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/create");
		 
		Paciente paciente = new Paciente();
		paciente.setNamePatient("diego");
		paciente.setLastNamePatient("diegoff");
		paciente.setDni("6666666");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);
		System.out.println("response -> "+output);
		Assert.assertEquals("{\"codigo\":\"1\",\"nombre\":\"diego creado\"}", output);
		
	}
	
	@Test
	public void testPutPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/update");
		 
		Paciente paciente = new Paciente();
		paciente.setId(3);
		paciente.setNamePatient("diego5");
		paciente.setLastNamePatient("diegoff5");
		paciente.setDni("66666665");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);
		System.out.println("response -> "+output);
		Assert.assertEquals("{\"id\":\"3\",\"namePatient\":\"diego\",\"lastNamePatient\":\"diegoff\",\"dni\":\"6666666\"}", output);
		
	}
	
	@Test
	public void testDeletePaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/remove/4");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);
		System.out.println("response -> "+output);
		Assert.assertEquals("eliminado", output);
		
	}
}
