package com.bank.DTOs.RequestLone;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LoneDTO {



    private int loneNumber;
    private int loneAmount;
    private int interest ;

    private int  duration ;

    private int customer;

    @Nullable
    @JsonFormat(pattern="MMM/yyyy")
    private LocalDateTime date ;




//    @PrePersist
//    private  void onCreate(){
//        date=new Date();
//
//    }
    public LoneDTO() {
    }

    public LoneDTO(int loneNumber, int loneAmount, int interest, int duration, int customer, @Nullable LocalDateTime date) {
        this.loneNumber = loneNumber;
        this.loneAmount = loneAmount;
        this.interest = interest;
        this.duration = duration;
        this.customer = customer;
        this.date = date;

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

    public int getCustomer() {
        return customer;
    }
    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Nullable
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(@Nullable LocalDateTime date) {
        this.date = date;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
    }


}
