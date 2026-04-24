package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer(1, "Oumou", "oumou@email.com");
        assertEquals(1, customer.getId());
        assertEquals("Oumou", customer.getName());
        assertEquals("oumou@email.com", customer.getEmail());
    }

    @Test
    public void testCustomerSetters() {
        Customer customer = new Customer(1, "Oumou", "oumou@email.com");
        customer.setId(2);
        customer.setName("William");
        customer.setEmail("william@email.com");
        assertEquals(2, customer.getId());
        assertEquals("William", customer.getName());
        assertEquals("william@email.com", customer.getEmail());
    }
}
