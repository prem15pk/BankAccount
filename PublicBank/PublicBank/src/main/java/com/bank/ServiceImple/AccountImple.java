package com.bank.ServiceImple;

import com.bank.DTOs.AccountDTO;
import com.bank.Entity.Account;


import com.bank.Entity.Customer;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.CustomerRepo;
import com.bank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountImple implements AccountService {
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

    public boolean updateAccount(int id , AccountDTO accountDTO){
       Account a = accountRepo.findById(id).orElse(null);
       a.setBalance(accountDTO.getBlance());
        accountRepo.save(a);
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
            account.setCreatingDate(account.getCreatingDate());
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
