package com.jdlf.restservice.service;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jdlf.restservice.dao.PacienteDao;
import com.jdlf.restservice.model.Paciente;

@Path("/pacientes")
public class PacienteService {
	
	private static PacienteDao dao;
	public PacienteService() {
		dao = new PacienteDao();
	}

	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente getPaciente (@PathParam("id") String id){	
		dao.openCurrentSessionwithTransaction();
		Paciente paciente = dao.findById(Integer.valueOf(id)); 
		dao.closeCurrentSessionwithTransaction();
		return paciente;
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente crearPaciente (Paciente paciente){
		dao.openCurrentSessionwithTransaction();
		paciente = dao.persist(paciente);
		dao.closeCurrentSessionwithTransaction();
		return paciente;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente actualizarPaciente (Paciente paciente){	
		dao.openCurrentSessionwithTransaction();
		Paciente paciente2 = dao.update(paciente);
		dao.closeCurrentSessionwithTransaction();
		return paciente2;
	}
	
	@DELETE
	@Path("/remove/{id}")
	public Response eliminarPaciente (@PathParam("id") String id){
		dao.openCurrentSessionwithTransaction();
		Paciente paciente = dao.findById(Integer.valueOf(id));
		dao.delete(paciente);
		dao.closeCurrentSessionwithTransaction();
		return Response.status(200).entity("eliminado").build();
	}

}