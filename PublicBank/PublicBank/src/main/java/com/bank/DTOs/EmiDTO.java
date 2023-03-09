package com.bank.DTOs;

import java.time.LocalDate;


public class EmiDTO {

    private int loneNumber;
    private int emiAmount;

    private LocalDate dueDate;

    private boolean isPaid;
    public EmiDTO() {
    }

    public EmiDTO(int loneNumber, int emiAmount, LocalDate dueDate, boolean isPaid) {
        this.loneNumber = loneNumber;
        this.emiAmount = emiAmount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
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
}
