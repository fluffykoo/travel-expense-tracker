package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer(1, "Alice", "alice@email.com");
        assertEquals(1, customer.getId());
        assertEquals("Alice", customer.getName());
        assertEquals("alice@email.com", customer.getEmail());
    }

    @Test
    public void testCustomerSetters() {
        Customer customer = new Customer(1, "Alice", "alice@email.com");
        customer.setId(2);
        customer.setName("Bob");
        customer.setEmail("bob@email.com");
        assertEquals(2, customer.getId());
        assertEquals("Bob", customer.getName());
        assertEquals("bob@email.com", customer.getEmail());
    }
}
