package com.bank.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;



import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @GeneratedValue
    private  int accountNumber=getRandomNumber(1000000000,99999999);


    private String accountName;

    private String ifseCode;
    private int balance;

    private String accountType;



    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    private Customer customer;

    private LocalDateTime creatingDate;


    private LocalDateTime updatedDate;


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Account (){}


    public Account(int id, int accountNumber, String accountName, String ifseCode,
                   int balance, String accountType, Customer customer, LocalDateTime creatingDate, LocalDateTime updatedDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.ifseCode = ifseCode;
        this.balance = balance;
        this.accountType = accountType;

        this.customer = customer;
        this.creatingDate = creatingDate;
        this.updatedDate = updatedDate;
    }


    public String getIfseCode() {
        return ifseCode;
    }

    public void setIfseCode(String ifseCode) {
        this.ifseCode = ifseCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName ;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDateTime getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(LocalDateTime creatingDate) {
        this.creatingDate = creatingDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getAccountId() {
        return id;
    }

    public void setAccountId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", creatingDate=" + creatingDate +
                ", updatedDate=" + updatedDate +

                '}';
    }
}
