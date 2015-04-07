package com.jdlf.restservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ExceptionHttpStatusResolver implements ExceptionMapper{

	public Response toResponse(Throwable exception) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
 
        return Response.status(httpStatus).entity(exception.getMessage())
                .build();
	}

}
