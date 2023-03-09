package com.bank.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LoneListCustomerDTO {

    private int loanNumber;
    private String createdDate;
    private int principalAmount;

    private  int balanceAmountToPay;

    private  int PaidAmount;
    public LoneListCustomerDTO() {
    }

    public LoneListCustomerDTO(int loanNumber, String createdDate, int principalAmount, int balanceAmountToPay, int paidAmount) {
        this.loanNumber = loanNumber;
        this.createdDate = createdDate;
        this.principalAmount = principalAmount;
        this.balanceAmountToPay = balanceAmountToPay;
        PaidAmount = paidAmount;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(int principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getBalanceAmountToPay() {
        return balanceAmountToPay;
    }

    public void setBalanceAmountToPay(int balanceAmountToPay) {
        this.balanceAmountToPay = balanceAmountToPay;
    }

    public int getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        PaidAmount = paidAmount;
    }
}
