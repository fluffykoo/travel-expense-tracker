package com.example.myservice.services;

import com.example.myservice.entities.Customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    @Test

    public void testAddAndGetCustomers() {

        CustomerService service = new CustomerService();

        Customer customer = new Customer(1, "Oumou", "oumou@email.com");

        service.addCustomer(customer);

        assertEquals(1, service.getCustomers().size());

    }

    @Test

    public void testGetCustomerById() {

        CustomerService service = new CustomerService();

        Customer customer = new Customer(1, "Oumou", "oumou@email.com");

        service.addCustomer(customer);

        assertEquals("Alice", service.getCustomerById(1).getName());

    }

    @Test

    public void testGetCustomerByIdNotFound() {

        CustomerService service = new CustomerService();

        assertNull(service.getCustomerById(99));

    }

    @Test

    public void testDeleteCustomer() {

        CustomerService service = new CustomerService();

        Customer customer = new Customer(1, "Oumou", "oumou@email.com");

        service.addCustomer(customer);

        service.deleteCustomer(1);

        assertEquals(0, service.getCustomers().size());

    }

}
