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

    //@Query("SELECT * FROM transaction n WHERE n.discription = description ")
      List<Transaction> findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc(int amount , String description);
//      List<Transaction> findAllBy(int balance);
         List<Transaction> findAll();

         List<Transaction> findByTransactionAmountOrderByTransactionDateDesc(int amount);

         List<Transaction> findByDiscriptionOrderByTransactionDateDesc(String description);

}
