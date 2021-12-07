package com.example.j2eestuff.ejb;


import com.example.j2eestuff.entities.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class PopulateData {

    @Inject
    ManagerEJB managerEJB;

    @PostConstruct
    public void init(){

        Customer customer = new Customer();
        customer.setName("michel smith");
        customer.setEmail("michel.smith@gmail.com");
        customer.setPhoneNumber("111 222 333 4445");
        customer.setAddress("12 Jhonson street");
        customer.setRequests(null);

        managerEJB.createCustomer(customer);
    }
}
