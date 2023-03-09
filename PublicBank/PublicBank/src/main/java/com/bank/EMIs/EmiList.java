package com.bank.EMIs;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EmiList {

    @Id
    @GeneratedValue
    private int id;
    @Nullable
    private int loneNumber;
    @Nullable
    private int emiAmount;
    @Nullable
    private LocalDate dateOfMonth;
    @Column(nullable = true)
    private int customerId;

    @Column(nullable = true , columnDefinition = "boolean default true")
    private boolean isPaid;
    public EmiList() {
    }

    public EmiList(int id, int loneNumber, int emiAmount, LocalDate dateOfMonth, int customerId, boolean isPaid) {
        this.id = id;
        this.loneNumber = loneNumber;
        this.emiAmount = emiAmount;
        this.dateOfMonth = dateOfMonth;
        this.customerId = customerId;
        this.isPaid = isPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }

    public LocalDate getDateOfMonth() {
        return dateOfMonth;
    }

    public void setDateOfMonth(LocalDate dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
