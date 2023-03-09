package com.bank.Repository;

import com.bank.Entity.TransActionToAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransActionToAccountRepo extends CrudRepository<TransActionToAccount, Integer> {
}
