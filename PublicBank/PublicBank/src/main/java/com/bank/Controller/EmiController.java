package com.bank.Controller;


import com.bank.DTOs.EmiDTO;

import com.bank.DTOs.LoneListCustomerDTO;
import com.bank.EMIs.EmiList;
import com.bank.Repository.EmiRepo;
import com.bank.ServiceImple.CustomerLoneImple;
import com.bank.ServiceImple.LoneImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/emi/")
public class EmiController {

    @Autowired
    CustomerLoneImple customerloneImple;
    @Autowired
   LoneImple loneImple;
    @Autowired
    private EmiRepo emiRepo;

    @PutMapping("updateEmiDue")
    public ResponseEntity<Object> updateEmiDue(@RequestBody EmiDTO emiDTO){

        String emiDTO1 = loneImple.updateEmiDue(emiDTO);

        if (emiDTO1 != null) return new ResponseEntity<>(emiDTO1, HttpStatus.CREATED);
        else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @GetMapping("getAllLoneWithCustomer-Id/{id}")
    public ResponseEntity<Object> getAllLoneWithCustomerId(@PathVariable int id ){

            List<LoneListCustomerDTO> loneListCustomerDTOS = customerloneImple.getAllLoneOfCustomer(id);

            if (loneListCustomerDTOS != null) return new ResponseEntity<>(loneListCustomerDTOS, HttpStatus.CREATED);
            else return new ResponseEntity<>("Error While Updating", HttpStatus.INTERNAL_SERVER_ERROR);
        }


}
