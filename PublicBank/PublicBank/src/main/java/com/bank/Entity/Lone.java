package com.bank.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class Lone {

    @Id
    @GeneratedValue
    private int id;

    private int loneAmount ;

    private  int loneNumber = getRandomNumber(1000000000,99999999);
    private int interest;
    private  int duration;
    @ManyToOne
    private Customer customer;


    private LocalDateTime gettingLone ;

    private LocalDateTime endDate;

//    @PrePersist
//    private  void onCreate(){
//        gettingLone=new LocalDate();
//
//    }



    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }



    public Lone() {
    }

    public Lone(int id, int loneAmount, int loneNumber, int interest, int duration, Customer customer, LocalDateTime gettingLone, LocalDateTime endDate) {
        this.id = id;
        this.loneAmount = loneAmount;
        this.loneNumber = loneNumber;
        this.interest = interest;
        this.duration = duration;
        this.customer = customer;
        this.gettingLone = gettingLone;
        this.endDate = endDate;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoneAmount() {
        return loneAmount;
    }

    public void setLoneAmount(int loneAmount) {
        this.loneAmount = loneAmount;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getGettingLone() {
        return gettingLone;
    }

    public void setGettingLone(LocalDateTime gettingLone) {
        this.gettingLone = gettingLone;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
