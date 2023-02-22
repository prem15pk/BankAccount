package com.bank.Controller;

import com.bank.DTOs.ViewDTO.PotsView;
import com.bank.Entity.Pots;
import com.bank.Repository.PotsRepository;
import com.bank.ServiceImple.PotsImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/pots/")
public class PotsController {

    @Autowired
    PotsImple potsImple;

    @Autowired
    PotsRepository potsRepository;
    @GetMapping("getPotsByAccountNumber/{accountNumber}")
    public ResponseEntity<Object> getPotsByAccountNumber(@PathVariable int accountNumber){

        int pots = potsRepository.findByAccountNumber(accountNumber).getAccountNumber();
        PotsView potsView = potsImple.getPotsByAccountNumber(pots);

        if (potsView != null && potsRepository.findByAccountNumber(accountNumber) != null) return new ResponseEntity<>(potsView, HttpStatus.CREATED);


        else return new ResponseEntity<>("no Pots", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
