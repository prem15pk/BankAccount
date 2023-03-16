package com.bank.ServiceImple;

import com.bank.DTOs.EmiDTO;
import com.bank.DTOs.LoneViewDTO;
import com.bank.DTOs.RequestLone.LoneDTO;
import com.bank.DTOs.RequestLone.LoneList;
import com.bank.DTOs.RequestLone.ViewLone;
import com.bank.DTOs.ViewDTO.ViewLoneDTO;
import com.bank.EMIs.EmiList;
import com.bank.Entity.Customer;
import com.bank.Entity.Lone;
import com.bank.Repository.CustomerRepo;
import com.bank.Repository.EmiRepo;
import com.bank.Repository.LoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoneImple {

    @Autowired
    EmiRepo emiRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    LoneRepo loneRepo;

    public List<Lone> getAllLone() {
        return (List<Lone>) loneRepo.findAll();
    }

    public LoneDTO saveLone(LoneDTO loneDTO) {
        Customer c = customerRepo.findById(loneDTO.getCustomer()).orElse(null);
        Lone lone = new Lone();
        lone.setLoneAmount((int) loneDTO.getLoneAmount());
        lone.setDuration(loneDTO.getDuration());
        lone.setInterest(loneDTO.getInterest());
        lone.setCustomer(c);
        lone.setLoneNumber(lone.getLoneNumber());
        lone.setGettingLone(LocalDate.now().plusMonths(loneDTO.getDuration()).atStartOfDay());

        lone.setEndDate(LocalDate.from(LocalDate.from(LocalDate.now().plusMonths(loneDTO.getDuration()))));

        loneRepo.save(lone);


        for (int i = 1; i <= loneDTO.getDuration(); i++) {
            EmiList emiList = new EmiList();
            emiList.setId(emiList.getId());
            emiList.setLoneNumber(lone.getLoneNumber());
            emiList.setDateOfMonth(LocalDate.now().plusMonths(i));
            emiList.setEmiAmount(loneDTO.getLoneAmount() / loneDTO.getDuration());
            emiList.setCustomerId(lone.getCustomer().getId());
            emiRepo.save(emiList);
        }


        LoneDTO loneDTOs = new LoneDTO();
        loneDTOs.setCustomer(loneDTO.getCustomer());
        loneDTOs.setLoneAmount(loneDTO.getLoneAmount());
        loneDTOs.setDuration(loneDTO.getDuration());
        loneDTOs.setInterest(loneDTO.getInterest());
        loneDTOs.setDate(lone.getGettingLone());
        loneDTOs.setLoneNumber(lone.getLoneNumber());
        return loneDTOs;
    }

    public ViewLone getAll(LoneDTO loneDTO) {

        ViewLone viewLone = new ViewLone();
        List<LoneViewDTO> loneViewDTOS = new ArrayList<>();
        viewLone.setLoneWithCustomerId(loneViewDTOS);
        if (loneDTO.getCustomer() != 0 && loneDTO.getLoneNumber() != 0) {

            List<Lone> lone = loneRepo.findByCustomer_idAndLoneNumber(loneDTO.getCustomer(), loneDTO.getLoneNumber());
             List<EmiList> emiLists = emiRepo.findByCustomerId(loneDTO.getCustomer());
            for (int i = 0; i < lone.size(); i++) {
                int countEmiPaid=0;
                LoneViewDTO loneViewDTO = new LoneViewDTO();
                Lone l = lone.get(i);
                loneViewDTO.setLoneNumber(l.getLoneNumber());
                loneViewDTO.setLoneAmount(l.getLoneAmount());
                loneViewDTO.setCustomerName(l.getCustomer().getName());
                for(EmiList emiList :emiLists) {
                    if (emiList.isPaid() == true) {
                        countEmiPaid = countEmiPaid + 1;
                    }
                }


                int monthlyEmi = (l.getLoneAmount() / l.getDuration());
                int paidAmount = (countEmiPaid)*(monthlyEmi);
                loneViewDTO.setMonthlyEmi(monthlyEmi);
                loneViewDTO.setBalanceAmountToPay(l.getLoneAmount()-paidAmount);
                loneViewDTO.setPaidAmount(paidAmount);
                loneViewDTOS.add(i, loneViewDTO);

            }
            return viewLone;

        } else if (loneDTO.getCustomer() != 0) {

            List<Lone> lone = loneRepo.findByCustomer_id(loneDTO.getCustomer());
            List<EmiList> emiLists = emiRepo.findByCustomerId(loneDTO.getCustomer());
            for (int i = 0; i < lone.size(); i++) {

                LoneViewDTO loneViewDTO = new LoneViewDTO();
                Lone l = lone.get(i);
                loneViewDTO.setLoneNumber(l.getLoneNumber());
                loneViewDTO.setLoneAmount(l.getLoneAmount());
                loneViewDTO.setCustomerName(l.getCustomer().getName());
                int monthlyEmi = (l.getLoneAmount() / l.getDuration());
                loneViewDTO.setMonthlyEmi(monthlyEmi);
                int countEmiPaid=0;

                for(EmiList emiList :emiLists) {
                    //int countEmiPaid=0;
                    if (emiList.isPaid()) {
                        countEmiPaid = countEmiPaid + 1;
                    }
                }
                int paidAmount = (countEmiPaid)*(monthlyEmi);
                loneViewDTO.setBalanceAmountToPay(l.getLoneAmount()-paidAmount);
                loneViewDTO.setPaidAmount(paidAmount);
                loneViewDTOS.add(i, loneViewDTO);


            }
            return viewLone;
        }

        return null;
    }

    public ViewLoneDTO getLoneIdList(int id, int loneNumber) {
        List<EmiList> lone = emiRepo.findByCustomerIdAndLoneNumber(id, loneNumber);
        List<LoneList> loneLists = new ArrayList<>();

        ViewLoneDTO viewLoneDTO = new ViewLoneDTO();
        viewLoneDTO.setCustomerLoans(loneLists);
//        for (int i = 0; i < lone.size(); i++) {
//            EmiList emiList = lone.get(i);
//            LoneList loneList = new LoneList();
//
//            loneList.setLoneNumber(emiList.getLoneNumber());
//            loneList.setDueDate(LocalDate.now());
//            loneList.setPaid(false);
//            loneLists.add(i, loneList);
//
//        }
        lone.stream().forEach(l->{
            LoneList loneList = new LoneList();
            loneList.setLoneNumber(l.getLoneNumber());
            loneList.setDueDate(LocalDate.now());
            loneList.setPaid(false);
            loneLists.add(loneList);
        });

        return viewLoneDTO;
    }

    public ViewLoneDTO getLoneListWithPaidEmi(int id, int loneNumber, boolean isPaid) {
        List<EmiList> lone = emiRepo.findByCustomerIdAndLoneNumberAndIsPaid(id, loneNumber, isPaid);

        List<LoneList> loneLists = new ArrayList<>();

        ViewLoneDTO viewLoneDTO = new ViewLoneDTO();
        viewLoneDTO.setCustomerLoans(loneLists);
        lone.stream().forEach(list->{
            LoneList loneList = new LoneList();
            loneList.setLoneNumber(list.getLoneNumber());
            loneList.setDueDate(list.getDateOfMonth());
            loneList.setPaid(list.isPaid());
            loneLists.add(loneList);
        });
//        for (int i = 0; i < lone.size(); i++) {
//            EmiList emiList = lone.get(i);
//            LoneList loneList = new LoneList();
//
//            loneList.setLoneNumber(emiList.getLoneNumber());
//            loneList.setDueDate(emiList.getDateOfMonth());
//            loneList.setPaid(emiList.isPaid());
//            loneLists.add(i, loneList);
//
//        }

        return viewLoneDTO;

    }


    public String updateEmiDue(EmiDTO emiDTO) {

        EmiList emiList = emiRepo.findByLoneNumberAndDateOfMonth(emiDTO.getLoneNumber(), emiDTO.getDueDate());
        if (emiList !=null) {
            if (emiDTO.getEmiAmount() == emiList.getEmiAmount()) {
                boolean b = emiList.isPaid();
                if (b != true) {
                    emiList.setPaid(true);
                } else {
                    return "Emi Already Paid";
                }
                emiRepo.save(emiList);
                return "Emi Paid For The Given Month";
            } else {
                return "Pay And Update Your Lone";
            }



        }
        else return "No Emi Is for This Date";
    }





}
