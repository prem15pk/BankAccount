package com.bank.Entity;
import javax.persistence.*;


@Entity
public class Pots {
    @Id
    @GeneratedValue
    private int id;
    private int accountNumber;

    private int potBalance;
    @OneToOne
    private Account account;

    public Pots() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPotBalance() {
        return potBalance;
    }

    public void setPotBalance(int potBalance) {
        this.potBalance = potBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
