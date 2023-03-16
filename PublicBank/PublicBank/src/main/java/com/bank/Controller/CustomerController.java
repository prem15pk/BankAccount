package com.bank.Controller;

import com.bank.Entity.Customer;
import com.bank.ServiceImple.CustomerImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bank/customer/")
public class CustomerController {

    @Autowired
    CustomerImple customerImple;

    @PostMapping("createCustomer")
     @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid Customer customer){
        Customer u = customerImple.saveCustomer(customer);
        if(u!=null)return new ResponseEntity<>(u, HttpStatus.CREATED);


        else  return new ResponseEntity<>("Error While Creating" ,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAll(){
        return customerImple.getAllCustomer();
    }



}
