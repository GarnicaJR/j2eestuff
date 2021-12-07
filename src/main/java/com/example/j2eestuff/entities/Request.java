package com.example.j2eestuff.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CUSTOMER_REQUEST")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    int quantity;
    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name="id_customer")
    private Customer customer;

    public Request() {
    }
    // Getters/Setters omitted for brevity


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}