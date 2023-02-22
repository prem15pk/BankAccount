package com.bank.Controller;

import com.bank.DTOs.AccountDTO;

import com.bank.Entity.Account;


import com.bank.Repository.AccountRepo;

import com.bank.ServiceImple.AccountImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bank/account/")
public class AccountController {


    @Autowired
    AccountImple accountImple;

    @Autowired
    AccountRepo accountRepo;

    //@PostMapping("createAccount")
    public ResponseEntity<Object> updateAccount(@RequestBody AccountDTO accountDTO) {

        Account a = accountImple.getByAccountId();

        if (a != null) return new ResponseEntity<>(a, HttpStatus.CREATED);


        else return new ResponseEntity<>("Error While Creating", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getAllAccount")
    public List<Account> getAll() {
        return (List<Account>) accountRepo.findAll();
    }

    @DeleteMapping("deleteAccount/{id}")
    public  ResponseEntity<Object> deleteAccount(@PathVariable int id){
        boolean a = accountImple.deleteAccount(id);

        if(a!=false) return new ResponseEntity<>(a, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Deleting", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("updateBalance/{id}")
    public ResponseEntity<Object> updateAccountBalance(@PathVariable int id ,@RequestBody Account account){
        boolean a = accountImple.updateAccountBlance(id,account);

        if(a!=false) return new ResponseEntity<>(a, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("createAccount")
    public ResponseEntity<Object> createAccount (@RequestBody AccountDTO accountDTO){
       Account a =  accountImple.saveAccount(accountDTO);


        if(a!=null  ) return new ResponseEntity<>(a, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
