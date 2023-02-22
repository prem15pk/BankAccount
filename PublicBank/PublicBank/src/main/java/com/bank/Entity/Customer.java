package com.bank.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id

    private int id;
    private String name;


    public Customer() {
    }


    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}