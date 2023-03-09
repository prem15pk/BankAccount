package com.bank.Controller;

import com.bank.DTOs.AccountDTO;
import com.bank.DTOs.LoneViewDTO;
import com.bank.DTOs.RequestLone.LoneDTO;
import com.bank.DTOs.RequestLone.LoneList;
import com.bank.DTOs.RequestLone.ViewLone;
import com.bank.DTOs.ViewDTO.ViewLoneDTO;
import com.bank.EMIs.EmiList;
import com.bank.Entity.Account;
import com.bank.Entity.Lone;
import com.bank.Repository.EmiRepo;
import com.bank.ServiceImple.LoneImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/lone/")
public class LoneController {
    @Autowired
    EmiRepo emiRepo;
    @Autowired
    LoneImple loneImple;

    @PostMapping("createLone")
    public ResponseEntity<Object> createAccount(@RequestBody LoneDTO loneDTO) {

        LoneDTO lone = loneImple.saveLone(loneDTO);


        if (lone != null) return new ResponseEntity<>(lone, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("getLone")
    public ResponseEntity<Object> getAllLone(@RequestBody LoneDTO loneDTO){

        ViewLone lone = loneImple.getAll(loneDTO);

        if (lone != null) return new ResponseEntity<>(lone, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("getAll-EmiList-With-LoneNumber")
    public ResponseEntity<Object> getAllEmiListWithLoneNumber(@RequestBody EmiList emiList){
        ViewLoneDTO loneList = loneImple.getLoneIdList(emiList.getCustomerId() , emiList.getLoneNumber());
        if (loneList != null) return new ResponseEntity<>(loneList, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getAll-EmiList-With-LoneNumber-paid-customerId")
    public ResponseEntity<Object> getAllEmiListWithLoneNumberIsPaidAndCustomerNumber(@RequestBody EmiList emiList){
        ViewLoneDTO loneList = loneImple.getLoneListWithPaidEmi(emiList.getCustomerId() , emiList.getLoneNumber(),emiList.isPaid());
        if (loneList != null) return new ResponseEntity<>(loneList, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}