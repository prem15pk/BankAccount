package com.bank.Repository;

import com.bank.EMIs.EmiList;
import com.bank.Entity.Lone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface EmiRepo extends CrudRepository<EmiList, Integer> {


    List<EmiList> findByLoneNumber(int LoneNumber);
    List<EmiList> findByCustomerIdAndLoneNumber(int id , int LoneNumber);

    EmiList findByLoneNumberAndDateOfMonth(int loneNumber , LocalDate endDate );

    List<EmiList> findByCustomerIdAndLoneNumberAndIsPaid(int id , int LoneNumber , boolean isPaid);

    List<EmiList> findByCustomerId(int id);

}
