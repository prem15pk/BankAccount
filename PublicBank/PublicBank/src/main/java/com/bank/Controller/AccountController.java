package com.bank.Controller;

import com.bank.DTOs.AccountDTO;

import com.bank.Entity.Account;


import com.bank.ErrorHandler.ErrorMessage;
import com.bank.Repository.AccountRepo;

import com.bank.Repository.CustomerRepo;
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
    CustomerRepo customerRepo;
    @Autowired
    AccountImple accountImple;

    @Autowired
    AccountRepo accountRepo;

    //@PostMapping("createAccount")
    public ResponseEntity<Object> updateAccount(@RequestBody AccountDTO accountDTO) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Error While Creating");
        Account a = accountImple.getByAccountId();

        if (a != null) return new ResponseEntity<>(a, HttpStatus.CREATED);


        else return new ResponseEntity<>(errorMessage.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

//    @PutMapping("updateBalance/{id}")
//    public ResponseEntity<Object> updateAccountBalance(@PathVariable int id ,@RequestBody Account account) {
//        if (accountRepo.findById(id).isPresent()) {
//            boolean a = accountImple.updateAccountBlance(id, account);
//
//            if (a != false) return new ResponseEntity<>(a, HttpStatus.CREATED);
//            else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
//        } else return new ResponseEntity<>("Check Your Id", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @PostMapping("createAccount")
    public ResponseEntity<Object> createAccount (@RequestBody AccountDTO accountDTO) {
        if ( customerRepo.findById(accountDTO.getCustomerId()).isPresent()) {
            Account a = accountImple.saveAccount(accountDTO);


            if (a != null) return new ResponseEntity<>(a, HttpStatus.CREATED);
            else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
        } else return new ResponseEntity<>(new ErrorMessage("unable to Create"), HttpStatus.INTERNAL_SERVER_ERROR);


    }

}
