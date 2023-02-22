package com.bank.ServiceImple;

import com.bank.Entity.Account;
import com.bank.Entity.Customer;
import com.bank.Repository.CustomerRepo;
import com.bank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerImple implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
       // Customer c = customerRepo.getById(id);

        return null;
    }
}
