package com.example.j2eestuff.rest;

import com.example.j2eestuff.entities.Customer;
import com.example.j2eestuff.mapper.EntityNotFoundMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(CustomerService.class);
        set.add(RequestService.class);
        set.add(EntityNotFoundMapper.class);
        return set;
    }
}