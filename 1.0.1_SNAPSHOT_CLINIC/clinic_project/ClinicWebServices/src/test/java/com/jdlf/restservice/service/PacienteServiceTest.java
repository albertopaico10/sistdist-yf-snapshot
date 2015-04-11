package com.jdlf.restservice.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import com.jdlf.restservice.model.Paciente;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PacienteServiceTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	Date date = new Date();
	
	@Test@Ignore
	public void testGetPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/3");
		 
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);			
		Paciente paciente = null;		
		paciente = parsePaciente(output, paciente);
		
		Assert.assertEquals(new Integer(3), paciente.getId());
		Assert.assertEquals("diego", paciente.getNamePatient());
		Assert.assertEquals("lopez", paciente.getLastNamePatient());
		
	}

	
	
	@Test
	public void testPostPaciente(){//create paciente
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes");
		 
		Paciente paciente = new Paciente();
		paciente.setNamePatient("diegoLF");
		paciente.setLastNamePatient("diegoLN");
		paciente.setDni("6666668");
		paciente.setBirthDay(new Date());
		paciente.setDateCreated(new Timestamp(date.getTime()));
		paciente.setDateUpdated(new Timestamp(date.getTime()));
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);		
		Paciente pacienteUpdated = null;
		pacienteUpdated = parsePaciente(output, pacienteUpdated);
		
		Assert.assertEquals("diegoLF", pacienteUpdated.getNamePatient());
		Assert.assertEquals("diegoLN", pacienteUpdated.getLastNamePatient());
		Assert.assertEquals("6666668", pacienteUpdated.getDni());
		
	}
	
	@Test@Ignore
	public void testPutPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes");
		 
		Paciente paciente = new Paciente();
		paciente.setId(5);
		paciente.setNamePatient("gg");
		paciente.setLastNamePatient("diegoff5");
		paciente.setDni("666666655");
		paciente.setBirthDay(new Date());
		paciente.setDateCreated(new Timestamp(date.getTime()));
		paciente.setDateUpdated(new Timestamp(date.getTime()));
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);
		Paciente pacienteUpdated = null;		
		pacienteUpdated = parsePaciente(output, pacienteUpdated);
		
		Assert.assertEquals(new Integer(5), pacienteUpdated.getId());
		Assert.assertEquals("gg", pacienteUpdated.getNamePatient());
		Assert.assertEquals("diegoff5", pacienteUpdated.getLastNamePatient());
		Assert.assertEquals("666666655", pacienteUpdated.getDni());
		
	}
	
	@Test@Ignore
	public void testDeletePaciente(){		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/5");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		Assert.assertEquals("eliminado", output);
		
	}
	
	@Test@Ignore
	public void testDeleteUnExistingPaciente(){
	
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/0");
			
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		Assert.assertTrue(output.contains("userId does not Exist"));
	}
	
	private Paciente parsePaciente(String output, Paciente paciente) {
		try {
			paciente = mapper.readValue(output, Paciente.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paciente;
	}
}
