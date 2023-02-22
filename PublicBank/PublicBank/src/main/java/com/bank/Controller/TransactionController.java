package com.bank.Controller;

import com.bank.DTOs.TransActionDTO;
import com.bank.DTOs.ViewDTO.TransActionView;
import com.bank.Entity.Account;

import com.bank.Filters.TransActionsFilter;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.TransactionRepo;
import com.bank.ServiceImple.TransactionImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/bank/transaction/")
public class TransactionController {

    @Autowired
    TransactionImple transactionImple;

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionRepo transactionRepo;
    @PostMapping("updateTransaction")
    public ResponseEntity<Object> UpdateTransAction(@RequestBody TransActionDTO transActionDTO){
        TransActionView t  = transactionImple.saveTransAction(transActionDTO);
         Account a  = accountRepo.findByAccountNumber(transActionDTO.getFromAccount());
        if (t != null && a.getBalance() >= transActionDTO.getTransactionAmount()  ) return new ResponseEntity<>(t, HttpStatus.CREATED);
        else return new ResponseEntity<>("InSufficient Balance Or Wrong Input",HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping("getAllTransAction")
    public ResponseEntity<Object> getAllTransaction(@RequestBody TransActionDTO transActionDTO) {

        //List<TransActionsFilter> transaction = transactionImple.getAllTransAction(transActionDTO);


//        List <Transaction> getAllTransactionAmount = transactionRepo.
//                findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc(transActionDTO.getTransactionAmount(),transActionDTO.getDiscription());

        if (transActionDTO.getFromAccount() == 0 && transActionDTO.getDiscription()==null){
            List<TransActionsFilter> transActionsFilters = transactionImple.getAllTransAction(transactionRepo.
                    findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc(transActionDTO.getTransactionAmount(), transActionDTO.getDiscription()));
            return new ResponseEntity<>(transActionsFilters, HttpStatus.CREATED);
        }

        else if (transActionDTO.getDiscription() == null && transActionDTO.getTransactionAmount()==0) {
            List<TransActionsFilter> transActionWithOutDescription =
                    transactionImple.findByFilterField(transactionRepo.findByTransactionAmountOrderByTransactionDateDesc(transActionDTO.getTransactionAmount()));
            return new ResponseEntity<>(transActionWithOutDescription, HttpStatus.CREATED);
        } else if (transActionDTO.getTransactionAmount()==0) {
            List<TransActionsFilter> transActionsWithOutAmount = transactionImple.getAllTransAction(
                    transactionRepo.findByDiscriptionOrderByTransactionDateDesc(transActionDTO.getDiscription()));
            return new ResponseEntity<>(transActionsWithOutAmount, HttpStatus.CREATED);

        } else {
            List<TransActionsFilter> findAllTransAction = transactionImple.getAllTransAction(
                    transactionRepo.findAll());

            return new ResponseEntity<>(findAllTransAction, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> isActive(TransActionDTO transActionDTO){
       return  null;
    }



}
