package com.bank.ServiceImple;

import com.bank.DTOs.TransActionDTO;
import com.bank.DTOs.ViewDTO.TransActionView;
import com.bank.Entity.Account;
import com.bank.Entity.Pots;
import com.bank.Entity.Transaction;
import com.bank.Filters.TransActionsFilter;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.PotsRepository;
import com.bank.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionImple   {


    @Autowired
    PotsRepository potsRepository;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionRepo transactionRepo;



    public Transaction updateTransAction(TransActionDTO transActionDTO) {

        Transaction t = new Transaction();


      Transaction ts =  transactionRepo.save(t);
        return ts;
    }

    public TransActionView saveTransAction(TransActionDTO transActionDTO){
        TransActionView transActionView = new TransActionView();


        Account fromAccount = accountRepo.findByAccountNumber(transActionDTO.getFromAccount());
        Account toAccount  = accountRepo.findByAccountNumber(transActionDTO.getToAccount());
        fromAccount.setBalance(fromAccount.getBalance() - transActionDTO.getTransactionAmount());
        toAccount.setBalance(transActionDTO.getTransactionAmount()+toAccount.getBalance());
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);


        /*     */
        /*     */


        Transaction transaction = new Transaction();
        transaction.setDiscription(transActionDTO.getDiscription());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setBlance(fromAccount.getBalance());
        transaction.setTransactionAmount(transActionDTO.getTransactionAmount());
        transaction.setActive(true);
        transactionRepo.save(transaction);

        /*     */
        /*     */


        transActionView.setDiscription(transActionDTO.getDiscription());
        transActionView.setTransActionId(transaction.getTid());
        transActionView.setTransActionId(transActionView.getTransActionId());
        transActionView.setTransactionAmount(transActionDTO.getTransactionAmount());
        transActionView.setBalance(fromAccount.getBalance());
        transActionView.setTransactionDate(transaction.getTransactionDate());
        transActionView.setFromAccount(transActionDTO.getFromAccount());
        transActionView.setToAccountNo(transActionDTO.getToAccount());
        transActionView.setCurrentBalance(fromAccount.getBalance());

        /*     */
        /*     */
        int balance = fromAccount.getBalance() - transActionDTO.getTransactionAmount();
       int roundBalance = Math.round(fromAccount.getBalance() - transActionDTO.getTransactionAmount()) - balance;
        //Pots pots =  potsRepository.findByAccountNumber(transActionDTO.getToAccount());
        Pots pots;
        if(potsRepository.findByAccountNumber(transActionDTO.getFromAccount()) == null){
             pots = new Pots();
            pots.setId(pots.getId());
            pots.setPotBalance(roundBalance);
            pots.setAccount(fromAccount);
            pots.setAccountNumber(fromAccount.getAccountNumber());
            potsRepository.save(pots);
        }
        else {

            pots = potsRepository.findByAccountNumber(transActionDTO.getFromAccount());

            pots.setPotBalance(pots.getPotBalance()+roundBalance);
           potsRepository.save(pots);

        }



        /* */

        /* */


       return transActionView;
    }


    public List<TransActionsFilter> getAllTransAction(List<Transaction> transActionDTO) {
        List<TransActionsFilter> transActionsFilters =new ArrayList<>();

        for(int i =0 ; i<=transActionDTO.size()-1;i++){
            TransActionsFilter transActionsFilter = new TransActionsFilter();

          Transaction transaction =  transActionDTO.get(i);
            transActionsFilter.setAccountHolderName(transaction.getFromAccount().getCustomer().getName());
            transActionsFilter.setAccountNumber(transaction.getFromAccount().getAccountNumber());
            transActionsFilter.setDate(transaction.getTransactionDate());
            transActionsFilter.setDescription(transaction.getDiscription());
            transActionsFilters.add(i,transActionsFilter);
        }

        return transActionsFilters;
    }













    public List<TransActionsFilter> findByFilterField(List<Transaction> transActionDTO){
        List<TransActionsFilter> transActionsFilters =new ArrayList<>();
        for(int i =0 ; i<=transActionDTO.size()-1;i++){
            TransActionsFilter transActionsFilter = new TransActionsFilter();

            Transaction transaction =  transActionDTO.get(i);
            transActionsFilter.setAccountHolderName(transaction.getFromAccount().getCustomer().getName());
            transActionsFilter.setAccountNumber(transaction.getFromAccount().getAccountNumber());
            transActionsFilter.setDate(transaction.getTransactionDate());
            transActionsFilter.setDescription(transaction.getDiscription());
            transActionsFilters.add(i,transActionsFilter);
        }

        return transActionsFilters;
    }




}
