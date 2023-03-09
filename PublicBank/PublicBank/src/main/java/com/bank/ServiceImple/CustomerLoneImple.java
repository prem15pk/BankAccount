package com.bank.ServiceImple;

import com.bank.DTOs.LoneListCustomerDTO;
import com.bank.DTOs.RequestLone.LoneList;
import com.bank.EMIs.EmiList;
import com.bank.Entity.Lone;
import com.bank.Repository.EmiRepo;
import com.bank.Repository.LoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerLoneImple {

    @Autowired
    EmiRepo emiRepo;
    @Autowired
    LoneRepo loneRepo;

    public List<LoneListCustomerDTO> getAllLoneOfCustomer(int id){

      List<Lone> lone = loneRepo.findByCustomer_id(id);

        List<LoneListCustomerDTO> loneListCustomerDTOS = new ArrayList<>();

      for(int i= 0 ; i<=lone.size()-1 ; i++){
          LoneListCustomerDTO loneListCustomerDTO = new LoneListCustomerDTO();
          int countOfPaid=0;
         Lone lone1 = lone.get(i);
          loneListCustomerDTO.setLoanNumber(lone1.getLoneNumber());

          /**/
          LocalDateTime myDateObj = LocalDateTime.now();
          DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
          String formattedDate = myDateObj.format(myFormatObj);
          loneListCustomerDTO.setCreatedDate(formattedDate);
          /**/

          loneListCustomerDTO.setPrincipalAmount(lone1.getLoneAmount());

        List<EmiList> emiLists = emiRepo.findByLoneNumber(lone1.getLoneNumber());
        for(int j=0 ; j<=emiLists.size()-1 ; j++){
            EmiList emiList = emiLists.get(j);
            if(emiList.isPaid()==true){
                countOfPaid=countOfPaid+1;
            }

        }
        int balance = (lone1.getDuration() -countOfPaid ) * (lone1.getLoneAmount()/lone1.getDuration());
          loneListCustomerDTO.setBalanceAmountToPay(balance);
          loneListCustomerDTO.setPaidAmount(lone1.getLoneAmount()-balance);
          loneListCustomerDTOS.add(i,loneListCustomerDTO);

      }
      return loneListCustomerDTOS;
    }


}
