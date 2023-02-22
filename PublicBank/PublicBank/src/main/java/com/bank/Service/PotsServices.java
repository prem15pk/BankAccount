package com.bank.Service;

import com.bank.Entity.Customer;
import com.bank.Entity.Pots;

import java.util.List;

public interface PotsServices {

    public List<Pots> getAllPots();
    public void savePots(Customer customer);
    public void deletePots(int id);

    public boolean updatePots(int id ,Customer customer);

}
