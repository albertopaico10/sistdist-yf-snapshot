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

import antlr.collections.List;

import com.jdlf.restservice.dao.PacienteDao;
import com.jdlf.restservice.model.Paciente;
import com.jdlf.restservice.queue.ClinicQueue;

@Path("/pacientes")
public class PacienteService {
	
	private static PacienteDao dao;
	public PacienteService() {
		dao = new PacienteDao();
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPacientes (){	
		dao.openCurrentSessionwithTransaction();
		java.util.List<Paciente> pacientes = dao.findAll(); 
		dao.closeCurrentSessionwithTransaction();
		return Response.status(200).entity(pacientes).build();
	}

	
	@GET
	//@Path("/get/{id}")
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaciente (@PathParam("id") String id) throws Exception{	
		dao.openCurrentSessionwithTransaction();
		Paciente paciente = dao.findById(Integer.valueOf(id)); 
		dao.closeCurrentSessionwithTransaction();
		
		if(paciente==null)
			throw new Exception("userId does not Exist");
		
		//return paciente;
		return Response.status(200).entity(paciente).build();
	}
	
	@POST
	//@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente crearPaciente (Paciente paciente) throws Exception{
		
		try {
			dao.openCurrentSessionwithTransaction();
			paciente = dao.persist(paciente);
			dao.closeCurrentSessionwithTransaction();
			return paciente;
		} catch (Exception e) {
			ClinicQueue.sendPaciente(paciente);
		}
		
		return paciente;
	}
	
	@PUT
	//@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente actualizarPaciente (Paciente paciente) throws Exception{	
		dao.openCurrentSessionwithTransaction();
		Paciente pac = dao.update(paciente);
		dao.closeCurrentSessionwithTransaction();
		return pac;
	}
	
	@DELETE
	//@Path("/remove/{id}")
	@Path("/{id}")
	public Response eliminarPaciente (@PathParam("id") String id) throws Exception{
		dao.openCurrentSessionwithTransaction();
		Paciente paciente = dao.findById(Integer.valueOf(id));
		
		if(paciente==null)
			throw new Exception("userId does not Exist");
		
		dao.delete(paciente);
		dao.closeCurrentSessionwithTransaction();
		return Response.status(200).entity("eliminado").build();
	}

}
