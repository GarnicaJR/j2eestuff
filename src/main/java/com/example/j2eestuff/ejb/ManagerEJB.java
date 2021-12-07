package com.example.j2eestuff.ejb;

import com.example.j2eestuff.entities.Customer;
import com.example.j2eestuff.entities.Request;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ManagerEJB {

    @PersistenceContext//this is the best to further info https://stackoverflow.com/questions/21038706/persistenceunit-vs-persistencecontext/21038785
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;

    private static final Logger LOGGER = Logger.getLogger(ManagerEJB.class.getName());


    public void createCustomer(Customer customer) {
        em.persist(customer);
        LOGGER.info("customer created " + customer);
    }

    public void createRequest(Long id, Request request) {

        Customer customer = findCustomerById(id);
        request.setCustomer(customer);
        em.persist(request);
        LOGGER.info("Request created " + request);
    }

    public void updateCustomer(Customer customer) {
        Customer customerToUpdate = findCustomerById(customer.getId());
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        LOGGER.info("Updated customer" + customer);
    }

    public void updateRequest(Request request) {
        Request requestToUpdate = findRequestById(request.getId());
        //  requestToUpdate.setProduct(request.getProduct());
        requestToUpdate.setQuantity(request.getQuantity());
        LOGGER.info("Updated request" + request);
    }

    public void deleteCustomer(Long customerId) {
        Customer c = findCustomerById(customerId);
        em.remove(c);
        LOGGER.info("Deleted Customer with id" + customerId);
    }

    public void deleteRequest(Long requestId) {
        Request r = findRequestById(requestId);
        em.remove(r);
        LOGGER.info("Deleted request with id" + requestId);
    }

    public Customer findCustomerById(Long id) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            throw new EntityNotFoundException("Customer with id of " + id + " does not exist.");
        }
        return customer;
    }

    public Request findRequestById(Long id) {
        Request request = em.find(Request.class, id);
        if (request == null) {
            throw new EntityNotFoundException("Request with id of " + id + " does not exist.");
        }
        return request;
    }

    public List<Customer> findAllCustomers() {
        Query query = em.createQuery("FROM Customer");
        List<Customer> customerList = query.getResultList();
        return customerList;
    }

    public List<Request> findAllRequests() {
        Query query = em.createQuery("FROM Request");
        List<Request> customerOrders = query.getResultList();
        return customerOrders;
    }

    public Customer findCustomerByName(String name) {
        Query query = em
                .createQuery("SELECT c FROM Customer c WHERE c.name = :name");
        query.setParameter("name", name);
        Customer customer = (Customer) query.getSingleResult();
        return customer;
    }

    public List<Request> findAllRequestsByCustomer(String name) {
        Query query = em.createQuery("SELECT r FROM Request r WHERE customer.name = :name");
        query.setParameter("name", name);
        List<Request> customerOrders = query.getResultList();
        return customerOrders;
    }
}
