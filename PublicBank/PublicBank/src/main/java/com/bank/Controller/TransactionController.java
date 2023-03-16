package com.bank.Controller;

import com.bank.DTOs.TransActionDTO;
import com.bank.DTOs.ViewDTO.TransActionView;
import com.bank.DTOs.ViewDTO.TransactionsList;
import com.bank.Entity.Account;

import com.bank.ErrorHandler.ErrorMessage;
import com.bank.Filters.TransActionsFilter;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.TransactionRepo;
import com.bank.ServiceImple.AccountImple;
import com.bank.ServiceImple.TransactionImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/bank/transaction/")
public class TransactionController {

    @Autowired
    AccountImple accountImple;
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
    public ResponseEntity<Object> getAllTransaction(@RequestBody TransActionsFilter transActionsFilter) {


//
//        if(transActionsFilter.getTransActionAmount() !=0 && transActionsFilter.getAccountNumber() !=0 &&transActionsFilter.getDescription() !=null ){
//
//            List<TransActionsFilter> getTransActionWithOutAccountHolderNameName =
//                    transactionImple.getAllTransAction(transactionRepo.findByFromAccount_AccountNumberAndTransactionAmountAndDiscriptionOrderByTransactionDateDesc
//                            (transActionsFilter.getAccountNumber(), transActionsFilter.getTransActionAmount(), transActionsFilter.getDescription()));
//            return new ResponseEntity<>(getTransActionWithOutAccountHolderNameName, HttpStatus.CREATED);
//        }
//
//        else if(transActionsFilter.getAccountNumber() == 0 && transActionsFilter.getTransActionAmount() ==0 ){
//            List<TransActionsFilter> getWithOutAccountNumberAndTransactionAmount = transactionImple.getAllTransAction
//                    (transactionRepo.findByDiscriptionOrderByTransactionDateDesc(transActionsFilter.getDescription()));
//            return new ResponseEntity<>(getWithOutAccountNumberAndTransactionAmount, HttpStatus.CREATED);
//        }
//
//        else if(transActionsFilter.getAccountNumber() == 0 && transActionsFilter.getDescription()==null ){
//            List<TransActionsFilter> getTransactionWithOutDescriptionAndAmount = transactionImple.getAllTransAction(transactionRepo.
//                    findByTransactionAmountOrderByTransactionDateDesc(transActionsFilter.getTransActionAmount()));
//            return new ResponseEntity<>(getTransactionWithOutDescriptionAndAmount, HttpStatus.CREATED);
//        }
//
//        else if(transActionsFilter.getTransActionAmount() ==0 && transActionsFilter.getDescription()==null ){
//            List<TransActionsFilter> getAll = transactionImple.getAllTransAction(transactionRepo.findAll());
//            return  new ResponseEntity<>(getAll, HttpStatus.CREATED);
//
//        }
//
//        else if(transActionsFilter.getDescription()==null ){
//            List<TransActionsFilter> getTransactionWithOutDescription = transactionImple.getAllTransAction(transactionRepo.
//                    findByTransactionAmountAndFromAccount_AccountNumberOrderByTransactionDateDesc(transActionsFilter.getTransActionAmount(),
//                            transActionsFilter.getAccountNumber()));
//            return new ResponseEntity<>(getTransactionWithOutDescription, HttpStatus.CREATED);
//        }
//
//        else if(transActionsFilter.getTransActionAmount() ==0){
//            List<TransActionsFilter> getTransactionWithOutAmount =
//            transactionImple.getAllTransAction(transactionRepo. findByFromAccount_AccountNumberAndDiscriptionOrderByTransactionDateDesc
//                    (transActionsFilter.getAccountNumber(),transActionsFilter.getDescription()));
//            return new ResponseEntity<>(getTransactionWithOutAmount, HttpStatus.CREATED);
//        }
//
//        else if (transActionsFilter.getAccountNumber() ==0){
//            List<TransActionsFilter> getWithoutAccountNumber =
//                    transactionImple.getAllTransAction(transactionRepo.findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc
//                            (transActionsFilter.getTransActionAmount(),
//                            transActionsFilter.getDescription()));
//            return new ResponseEntity<>(getWithoutAccountNumber, HttpStatus.CREATED);
//        }
//
//
//
//
//
//        else {
//            List<TransActionsFilter> getAll = transactionImple.getAllTransAction(transactionRepo.findAll());
//        return  new ResponseEntity<>(getAll, HttpStatus.CREATED);
//        }
        Object getAllTransActions = transactionImple.getAllImplementation(transActionsFilter);

        if (getAllTransActions != null && (transActionsFilter.getDescription() !=("Paytm".toUpperCase())|| transActionsFilter.getDescription() !=("GPay".toUpperCase()) || transActionsFilter.getDescription()==null)) return new ResponseEntity<>(getAllTransActions, HttpStatus.CREATED);
        else return new ResponseEntity<>("NetWork is Not Linked",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<Object> isActive(TransActionDTO transActionDTO){
       return  null;
    }

    @PostMapping("updateBalance")
    public ResponseEntity<Object> UpdateBalance(@RequestBody  TransActionDTO transActionDTO){
         if(accountRepo.findByAccountNumber(transActionDTO.getFromAccount())!=null) {
             boolean b = accountImple.updateAccount(transActionDTO.getFromAccount(), transActionDTO.getTransactionAmount());

             if (b != false) return new ResponseEntity<>(true, HttpStatus.CREATED);
             else return new ResponseEntity<>(new ErrorMessage("Check your id"), HttpStatus.METHOD_NOT_ALLOWED);
         }
         else return new ResponseEntity<>(new ErrorMessage("Check your id"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("getAllTransActions")
    public ResponseEntity<Object> getAllTransActions(@RequestBody TransActionsFilter transActionsFilter){


            if(transActionsFilter.getAccountNumber()!=0) {
                TransactionsList transactionsList = transactionImple.getAllTransActions(transActionsFilter);
                return new ResponseEntity<>(transactionsList, HttpStatus.CREATED);
            }
            else return new ResponseEntity<>(new ErrorMessage("Account number is needed"), HttpStatus.METHOD_NOT_ALLOWED);
        }


    }



