package com.bank.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name="transaction")
public class Transaction {

    public enum TransActionTypes{Debit,Credit,Deposit}
    @Id
    @GeneratedValue
    private int tid;

    private int blance;

    @OneToOne
    private Account fromAccount;
    @OneToOne
    private Account toAccount;
    private int transactionAmount;
    private String discription;

    private String transActionType;

    private  boolean isActive;
    @ManyToOne(cascade = CascadeType.ALL , targetEntity = Account.class)
    private Account accountList;


    private LocalDateTime transactionDate ;

    //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private  int customerId;



    public Transaction() {
    }

    public Transaction(int tid, int blance, Account fromAccount, Account toAccount, int transactionAmount,
                       String discription, String transActionType, boolean isActive, Account accountList, LocalDateTime transactionDate) {
        this.tid = tid;
        this.blance = blance;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionAmount = transactionAmount;
        this.discription = discription;
        this.transActionType = transActionType;
        this.isActive = isActive;
        this.accountList = accountList;
        this.transactionDate = transactionDate;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return tid;
    }

    public void setId(int id) {
        this.tid = id;
    }



    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Account getAccountList() {
        return accountList;
    }

    public void setAccountList(Account accountList) {
        this.accountList = accountList;
    }

    public String getTransActionType() {
        return transActionType;
    }

    public void setTransActionType(String transActionType) {
        this.transActionType = transActionType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +

                ", balance=" + blance +
                ", fromAccount=" + fromAccount +
                ", toAccount='" + toAccount + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", description='" + discription + '\'' +
                ", isActive=" + isActive +
                ", accountList=" + accountList +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
