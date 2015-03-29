package com.project.george.facade.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.project.george.bean.catalog.paciente.Patient;
import com.project.george.facade.service.PatientService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Service
public class PatientServiceImpl implements PatientService {
	
	ObjectMapper mapper = new ObjectMapper();

	public Patient savePatient(Patient patient) {
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/create");

		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, patient);
		
		String output = clientResponse.getEntity(String.class);		
		Patient pacienteSaved = null;
		pacienteSaved = parsePaciente(output, pacienteSaved);
		return pacienteSaved;
	}

	public Patient updatePatient(Patient patient) {
		
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/update");
		 		
		ClientResponse clientResponse = resource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, patient);
		
		String output = clientResponse.getEntity(String.class);
		Patient pacienteUpdated = null;		
		pacienteUpdated = parsePaciente(output, pacienteUpdated);
		return pacienteUpdated;
	}

	public Patient getPatient(Integer id) {
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/get/"+id);
		 
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);			
		Patient patient = null;		
		patient = parsePaciente(output, patient);
		return patient;
	}

	public String removePatient(Integer id) {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/remove/"+id);
		
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		return output;
	}

	public List<Patient> getPatients() {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/ClinicWebServices/rest/pacientes/getAll/");
		 
		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = clientResponse.getEntity(String.class);			
		
		ObjectMapper objectMapper = new ObjectMapper();

		List<Patient> list = new ArrayList<Patient>();
		
	    try {
			list = objectMapper.readValue(
					output,
			        objectMapper.getTypeFactory().constructCollectionType(
			                List.class, Patient.class));
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
		
		return list;
	}
	
	private Patient parsePaciente(String output, Patient paciente) {
		try {
			paciente = mapper.readValue(output, Patient.class);
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
