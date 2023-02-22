package com.bank.Repository;

import com.bank.Entity.Pots;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotsRepository extends  CrudRepository<Pots,Integer> {

    Pots findByAccountNumber(int accountNumber);

}
