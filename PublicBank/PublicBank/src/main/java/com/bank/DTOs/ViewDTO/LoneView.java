package com.bank.DTOs.ViewDTO;

import com.bank.DTOs.LoneViewDTO;
import com.bank.DTOs.RequestLone.LoneDTO;
import com.bank.Entity.Lone;

import java.util.List;

public class LoneView {

    private List<LoneViewDTO> loneList;

    public void setLoneList(List<LoneViewDTO> loneList) {
        this.loneList = loneList;
    }
}
