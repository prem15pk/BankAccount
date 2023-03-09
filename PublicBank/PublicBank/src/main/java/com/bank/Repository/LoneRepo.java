package com.bank.Repository;

import com.bank.Entity.Lone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoneRepo extends CrudRepository<Lone,Integer> {

    List<Lone> findByCustomer_idAndLoneNumber(int cId , int loneNumber);

    List<Lone> findByCustomer_id(int cId);




}
