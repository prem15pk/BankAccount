package com.bank.DTOs.ViewDTO;

import java.util.Date;

public class TransActionView {
    private int transActionId;
    private int balance;

    private int toAccountNo;
    private int fromAccount;
    private int transactionAmount;

    private int currentBalance;
    private Date transactionDate;
    private String discription;
    public TransActionView() {
    }

    public TransActionView(int transActionId, int balance, int toAccountNo, int fromAccount, int transactionAmount,
                           int currentBalance, Date transactionDate, String discription) {
        this.transActionId = transActionId;
        this.balance = balance;
        this.toAccountNo = toAccountNo;
        this.fromAccount = fromAccount;
        this.transactionAmount = transactionAmount;
        this.currentBalance = currentBalance;
        this.transactionDate = transactionDate;
        this.discription = discription;
    }


    public int getTransActionId() {
        return transActionId;
    }

    public void setTransActionId(int transActionId) {
        this.transActionId = transActionId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(int toAccountNo) {
        this.toAccountNo = toAccountNo;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate(Date transactionDate) {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "TransActionView{" +
                "transActionId=" + transActionId +
                ", balance=" + balance +
                ", toAccountNo=" + toAccountNo +
                ", fromAccount=" + fromAccount +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                ", discription='" + discription + '\'' +
                '}';
    }
}
