package com.example.j2eestuff.rest;

import com.example.j2eestuff.ejb.ManagerEJB;
import com.example.j2eestuff.entities.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {
    @Inject
    ManagerEJB ejb;

    @POST
    public Response create(Customer customer) {
        ejb.createCustomer(customer);
        return Response.status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response findCustomerById(@PathParam("id") long id){
        Customer customer = ejb.findCustomerById(id);
        return Response.ok(customer).build();
    }

    @GET
    public List<Customer> findAllCustomers() {
        return ejb.findAllCustomers();
    }

    @PUT
    public Response updateCustomer(Customer customer) {
        ejb.updateCustomer(customer);
        return Response.status(204).build();
    }

    @DELETE
    public Response delete(@QueryParam("id") Long id) {
        ejb.deleteCustomer(id);
        return Response.status(204).build();
    }
}
