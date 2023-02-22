package com.bank.Filters;


import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class TransActionsFilter {


    @Nullable
    private String AccountHolderName;


    @NotNull
    private int accountNumber;
    @Nullable
    private String Description;

    @Nullable
    private Date date;
    public TransActionsFilter() {
    }

    public TransActionsFilter(@Nullable String accountHolderName, int accountNumber, @Nullable String description, @Nullable Date date) {
        AccountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        Description = description;
        this.date = date;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Nullable
    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(@Nullable String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    @Nullable
    public Date getDate() {
        return date;
    }

    public void setDate(@Nullable Date date) {
        this.date = date;
    }
}
