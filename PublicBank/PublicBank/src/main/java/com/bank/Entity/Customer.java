package com.bank.Entity;




import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;




@Entity
@Table(name="customer")
public class Customer {


    @Id

    private int id;

    @NotBlank(message = "Name is Empty")
    @Pattern(regexp ="[a-zA-Z]+" , message = "Check your Name")
    @Pattern(regexp = "[a-zA-Z]{4,12}" , message = "Minimum Length 4 , Maximum 12")
    //@Min(4) @Max(8)
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