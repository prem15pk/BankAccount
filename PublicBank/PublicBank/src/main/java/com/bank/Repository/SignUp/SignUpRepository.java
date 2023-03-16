package com.bank.Repository.SignUp;

import com.bank.SignUp.CustomersSignUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends CrudRepository<CustomersSignUp, Integer> {

    Optional<CustomersSignUp> findByName(String name);
}
