package com.bank.Repository;

import com.bank.Entity.Account;

import com.bank.Entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepo extends CrudRepository<Account,Integer> {

    Account findByAccountNumber(int accountNumber);


}
