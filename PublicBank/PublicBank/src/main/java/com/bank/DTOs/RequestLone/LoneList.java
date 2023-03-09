package com.bank.DTOs.RequestLone;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoneList {

   private int loneNumber;

   private LocalDate dueDate;
   private boolean isPaid;

    public LoneList() {
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LoneList(int loneNumber) {
        this.loneNumber = loneNumber;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
    }
}
