package com.example.java_iii_ipd25;


import com.example.java_iii_ipd25.entity.Customer;

public interface CustomerDatabase {

    // Abstract methods
    boolean save(Customer customer);

    Customer findCustomerById(int id);

    Customer removeCustomerById(int id);
}
