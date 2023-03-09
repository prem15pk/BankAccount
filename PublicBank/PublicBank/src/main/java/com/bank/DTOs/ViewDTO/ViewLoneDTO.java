package com.bank.DTOs.ViewDTO;

import com.bank.DTOs.RequestLone.LoneList;

import java.util.Arrays;
import java.util.List;

public class ViewLoneDTO {

    private List<LoneList> customerLoans;

    public List<LoneList> getCustomerLoans() {
        return customerLoans;
    }

    public void setCustomerLoans(List<LoneList> customerLoans) {
        this.customerLoans = customerLoans;
    }
}
