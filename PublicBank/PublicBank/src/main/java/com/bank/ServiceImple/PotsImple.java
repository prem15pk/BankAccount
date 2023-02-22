package com.bank.ServiceImple;

import com.bank.DTOs.ViewDTO.PotsView;
import com.bank.Entity.Customer;

import com.bank.Entity.Pots;
import com.bank.Repository.PotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PotsImple{


    @Autowired
    PotsRepository potsRepository;
    public Customer Pots(Customer customer) {
        return null;
    }

    public PotsView  getPotsByAccountNumber(int accountNumber){
      Pots pots =    potsRepository.findByAccountNumber(accountNumber);


      PotsView potsView = new PotsView();
      potsView.setAccountNumber(pots.getAccountNumber());
      potsView.setBalance(pots.getPotBalance());
      return potsView;

    }



}
