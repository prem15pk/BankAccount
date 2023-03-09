package com.bank.Filters;


import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TransActionsFilter {


    @Nullable
    private String AccountHolderName;


    @NotNull
    private int accountNumber;
    private String description;


    private String date;

    private  int transActionAmount;
    public TransActionsFilter() {
    }



    public TransActionsFilter(String accountHolderName, int accountNumber, String description, String date, int transActionAmount) {
        AccountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.description = description;
        this.date = date;
        this.transActionAmount = transActionAmount;
    }
    //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(@Nullable String accountHolderName) {
        AccountHolderName = accountHolderName;
    }


    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    public int getTransActionAmount() {
        return transActionAmount;
    }

    public void setTransActionAmount(int transActionAmount) {
        this.transActionAmount = transActionAmount;
    }




}
