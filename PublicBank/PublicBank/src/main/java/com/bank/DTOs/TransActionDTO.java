package com.bank.DTOs;


import org.springframework.lang.Nullable;

import java.util.Date;

public class TransActionDTO {



    @Nullable
    private int fromAccount;
    @Nullable
    private int toAccount;
    @Nullable
    private int transactionAmount;
    @Nullable
    private String discription;

    @Nullable
    private  boolean isActive;

    @Nullable
    private Date date;


    public TransActionDTO() {
    }

    public TransActionDTO(int fromAccount, int toAccount, int transactionAmount, @Nullable String discription, boolean isActive, Date date) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionAmount = transactionAmount;
        this.discription = discription;
        this.isActive = isActive;
        this.date = date;

    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "TransActionDTO{" +


                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", transactionAmount=" + transactionAmount +
                ", discription='" + discription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
