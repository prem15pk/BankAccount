package com.bank.DTOs.ViewDTO;

import com.bank.EMIs.EmiList;

import java.util.List;

public class ViewEmiDTO {

    private List<EmiList> emiListList;

    public void setEmiListList(List<EmiList> emiListList) {
        this.emiListList = emiListList;
    }
}
