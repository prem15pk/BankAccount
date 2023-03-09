package com.bank.DTOs.ViewDTO;

import com.bank.Filters.TransActionsFilter;

import java.util.List;

public class TransactionsList {

    private List<TransActionsFilter> transactionsList;

    public TransactionsList() {
    }

    public TransactionsList(List<TransActionsFilter> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public List<TransActionsFilter> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<TransActionsFilter> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
