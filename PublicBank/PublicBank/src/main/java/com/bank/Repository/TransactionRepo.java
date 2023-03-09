package com.bank.Repository;

import com.bank.DTOs.TransActionDTO;
import com.bank.Entity.Transaction;
import com.bank.Filters.TransActionsFilter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction,Integer> {
    List<Transaction> findByFromAccount_AccountNumber(int accountNumber);


      List<Transaction> findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc(int amount , String description);
      List<Transaction> findByTransactionAmountAndFromAccount_AccountNumberAndDiscriptionOrderByTransactionDateDesc(int amount , int accountNumber , String description);

    List<Transaction> findByFromAccount_AccountNumberAndTransactionAmountAndDiscriptionOrderByTransactionDateDesc(int accountNumber, int transactionAmount, String discription);

      List<Transaction> findByTransactionAmountAndFromAccount_AccountNumberOrderByTransactionDateDesc(int amount , int accountNumber);

      List<Transaction> findByFromAccount_AccountNumberAndDiscriptionOrderByTransactionDateDesc(int accountNumber , String description);

      //List<Transaction> findByFromAccount_AccountNumberOrderByTransactionDateDesc(int accountNumber);



         List<Transaction> findAll();

         List<Transaction> findByTransactionAmountOrderByTransactionDateDesc(int amount);

         List<Transaction> findByDiscriptionOrderByTransactionDateDesc(String description);

       // List<Transaction> findByFromAccount_AccountNumberAndAndTransactionAmountOrderByTransactionDateDesc(int accountNumber , int amount);



}
