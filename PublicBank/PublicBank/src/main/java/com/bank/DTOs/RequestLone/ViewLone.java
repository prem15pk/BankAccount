package com.bank.DTOs.RequestLone;

import com.bank.DTOs.LoneViewDTO;

import java.util.List;

public class ViewLone {

    private List<LoneViewDTO> loneWithCustomerId;

    public ViewLone() {
    }

    public ViewLone(List<LoneViewDTO> loneWithCustomerId) {
        this.loneWithCustomerId = loneWithCustomerId;
    }

    public List<LoneViewDTO> getLoneWithCustomerId() {
        return loneWithCustomerId;
    }

    public void setLoneWithCustomerId(List<LoneViewDTO> loneWithCustomerId) {
        this.loneWithCustomerId = loneWithCustomerId;
    }
}
