package com.example.myservice.services;

import com.example.myservice.entities.Customer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}
