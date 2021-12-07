package com.example.j2eestuff.mapper;


import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundMapper
        implements ExceptionMapper<EntityNotFoundException> {


    @Override
    public Response toResponse(EntityNotFoundException exception) {
        String errorMessage = exception.getMessage();
        return Response.status(Response.Status.NOT_FOUND)//or whatever other status is more appropriate
                .entity(new ErrorMessage(errorMessage))
                .build();
    }
}
