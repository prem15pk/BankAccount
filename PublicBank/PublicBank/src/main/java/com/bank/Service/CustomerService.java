package com.bank.Service;

import com.bank.Entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomer();
    public Customer saveCustomer(Customer customer);

    public  Customer getCustomerById(int id);
}
