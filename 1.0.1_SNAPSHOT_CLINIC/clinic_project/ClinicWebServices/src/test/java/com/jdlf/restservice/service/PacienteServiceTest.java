package com.jdlf.restservice.service;

import java.io.IOException;
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
	
	@Test
	public void testGetPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/get/3");
		 
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);			
		Paciente paciente = null;		
		paciente = parsePaciente(output, paciente);
		
		Assert.assertEquals(new Integer(3), paciente.getId());
		Assert.assertEquals("diego5", paciente.getNamePatient());
		Assert.assertEquals("diegoff5", paciente.getLastNamePatient());
		Assert.assertEquals("66666665", paciente.getDni());
		Assert.assertEquals("San Borja", paciente.getDistrictName());	
		
	}

	
	
	@Test
	public void testPostPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/create");
		 
		Paciente paciente = new Paciente();
		paciente.setNamePatient("diegoLF");
		paciente.setLastNamePatient("diegoLN");
		paciente.setDni("6666667");
		paciente.setBirthDay(new Date());
		paciente.setDateCreated(new Date());
		paciente.setDateUpdated(new Date());
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);		
		Paciente pacienteUpdated = null;
		pacienteUpdated = parsePaciente(output, pacienteUpdated);
		
		Assert.assertEquals("diegoLF", pacienteUpdated.getNamePatient());
		Assert.assertEquals("diegoLN", pacienteUpdated.getLastNamePatient());
		Assert.assertEquals("6666667", pacienteUpdated.getDni());
		
	}
	
	@Test
	public void testPutPaciente(){
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/update");
		 
		Paciente paciente = new Paciente();
		paciente.setId(5);
		paciente.setNamePatient("diego5");
		paciente.setLastNamePatient("diegoff5");
		paciente.setDni("666666655");
		paciente.setBirthDay(new Date());
		paciente.setDateCreated(new Date());
		paciente.setDateUpdated(new Date());
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);
		
		String output = clientResponse.getEntity(String.class);
		Paciente pacienteUpdated = null;		
		pacienteUpdated = parsePaciente(output, pacienteUpdated);
		
		Assert.assertEquals(new Integer(5), pacienteUpdated.getId());
		Assert.assertEquals("diego5", pacienteUpdated.getNamePatient());
		Assert.assertEquals("diegoff5", pacienteUpdated.getLastNamePatient());
		Assert.assertEquals("666666655", pacienteUpdated.getDni());
		
	}
	
	@Test
	@Ignore
	public void testDeletePaciente(){		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/remove/7");
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		Assert.assertEquals("eliminado", output);
		
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
