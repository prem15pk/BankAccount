package com.bank.ServiceImple;

import com.bank.DTOs.AccountDTO;
import com.bank.DTOs.TransActionDTO;
import com.bank.Entity.Account;


import com.bank.Entity.Customer;
import com.bank.Entity.Transaction;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.CustomerRepo;
import com.bank.Repository.TransactionRepo;
import com.bank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service()
public class AccountImple implements AccountService {

    @Autowired
    TransactionRepo transactionRepo;
     @Autowired
     AccountRepo accountRepo;

     @Autowired
     CustomerRepo customerRepo;
    @Override
    public List<Account> getAllAccount() {
        return (List<Account>)accountRepo.findAll();
    }

    @Override
    public Account getByAccountId() {
        return null;
    }




    public Account getByAccountId(Account account) {
        return null;
    }

    public boolean deleteAccount(int id){
        if(accountRepo.findById(id).isPresent()){
            accountRepo.deleteById(id);
            return true;
        }


        return false;
    }

    public boolean updateAccount(int id , int balance){
       Account account = accountRepo.findByAccountNumber(id);
        account.setBalance(account.getBalance()+balance);
        accountRepo.save(account);

        /**/
        /**/

        Transaction transAction = new Transaction();
        transAction.setFromAccount(account);
        transAction.setDiscription("Deposit");
        transAction.setActive(true);
        transAction.setTransactionDate(LocalDateTime.now());
        transAction.setTransactionAmount(balance);
        transAction.setCustomerId(account.getId());
        transAction.setBlance(account.getBalance());

        transactionRepo.save(transAction);

            return  true;

    }

    public Account saveAccount(AccountDTO accountDTO){

       Customer c = customerRepo.findById(accountDTO.getCustomerId()).orElse(null);

        Account account = new Account();

     int a=account.getAccountNumber();
     while(a!= account.getAccountNumber())

            account.setAccountNumber(a);

            account.setAccountName(accountDTO.getAccountName());
            account.setIfseCode(accountDTO.getIfseCode());
            account.setBalance(accountDTO.getBlance());
            account.setAccountType(accountDTO.getAccountType());
            account.setCustomer(c);
            account.setCreatingDate(LocalDateTime.now());
            account.setUpdatedDate(account.getUpdatedDate());
            account.setAccountId(account.getAccountId());
            accountRepo.save(account);

            return account;
        }




    public boolean updateAccountBlance( int id, Account account){
      Account a =  accountRepo.findById(id).orElse(null);

        a.setBalance(account.getBalance() + a.getBalance());
        accountRepo.save(a);



        return true;
    }
}
