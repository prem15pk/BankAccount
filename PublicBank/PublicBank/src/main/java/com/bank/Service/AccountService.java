package com.bank.Service;

import com.bank.Entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccount();
    public Account getByAccountId();
}
