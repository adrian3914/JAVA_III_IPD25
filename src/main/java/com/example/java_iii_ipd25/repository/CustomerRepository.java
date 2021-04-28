package com.example.java_iii_ipd25.repository;


import com.example.java_iii_ipd25.entity.Customer;
import org.springframework.data.repository.CrudRepository;

// Class where the magic happens for springFramework
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
