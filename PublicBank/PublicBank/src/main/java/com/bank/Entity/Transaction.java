package com.bank.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="transaction")
public class Transaction {
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


    private  boolean isActive;
    @ManyToOne(cascade = CascadeType.ALL , targetEntity = Account.class)
    private Account accountList;

    @JsonFormat(pattern="dd/MM/yyyy hh:MM:ss")
    private Date transactionDate;

    @PrePersist
    private  void  onCreat(){
        transactionDate=new Date();

    }

    public Transaction() {
    }

    public Transaction(int tid, int blance, Account fromAccount, Account toAccount, int transactionAmount,
                       String discription, boolean isActive, Date transactionDate) {
        this.tid = tid;

        this.blance = blance;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionAmount = transactionAmount;
        this.discription = discription;
        this.isActive = isActive;

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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
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
