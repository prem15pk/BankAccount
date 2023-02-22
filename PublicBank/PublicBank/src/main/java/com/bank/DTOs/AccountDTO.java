package com.bank.DTOs;



public class AccountDTO {

    private String accountName;
    private String ifseCode;
    private String accountType;
    private int blance;
    private int  customerId;

    public AccountDTO() {
    }

    public AccountDTO(String accountName, String ifseCode, String accountType, int blance, int customerId) {
        this.accountName = accountName;
        this.ifseCode = ifseCode;
        this.accountType = accountType;
        this.blance = blance;
        this.customerId = customerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIfseCode() {
        return ifseCode;
    }

    public void setIfseCode(String ifseCode) {
        this.ifseCode = ifseCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountName='" + accountName + '\'' +
                ", ifseCode='" + ifseCode + '\'' +
                ", AccountType='" + accountType + '\'' +
                ", blance=" + blance +

                '}';
    }
}
