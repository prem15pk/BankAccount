package com.bank.DTOs;

import org.springframework.lang.Nullable;

public class LoneViewDTO {
    @Nullable
    private String customerName;
    @Nullable
    private int loneNumber;
    @Nullable
    private int loneAmount;
    @Nullable
    private int monthlyEmi;
    @Nullable
    private int paidAmount;

    @Nullable
  private int balanceAmountToPay;

    public LoneViewDTO() {
    }

    public LoneViewDTO(@Nullable String customerName, int loneNumber, int loneAmount, int monthlyEmi, int paidAmount, int balanceAmountToPay) {
        this.customerName = customerName;
        this.loneNumber = loneNumber;
        this.loneAmount = loneAmount;
        this.monthlyEmi = monthlyEmi;
        this.paidAmount = paidAmount;
        this.balanceAmountToPay = balanceAmountToPay;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getLoneNumber() {
        return loneNumber;
    }

    public void setLoneNumber(int loneNumber) {
        this.loneNumber = loneNumber;
    }

    public int getLoneAmount() {
        return loneAmount;
    }

    public void setLoneAmount(int loneAmount) {
        this.loneAmount = loneAmount;
    }

    public int getMonthlyEmi() {
        return monthlyEmi;
    }

    public void setMonthlyEmi(int monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getBalanceAmountToPay() {
        return balanceAmountToPay;
    }

    public void setBalanceAmountToPay(int balanceAmountToPay) {
        this.balanceAmountToPay = balanceAmountToPay;
    }
}
