package com.example.java_iii_ipd25.controller;


import com.example.java_iii_ipd25.entity.Customer;
import com.example.java_iii_ipd25.entity.Purchase;
import com.example.java_iii_ipd25.repository.CustomerRepository;
import com.example.java_iii_ipd25.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

// Identifying class as Controller
@Controller
public class PurchaseMvcController {

    // Must autowired each reference field Interfaces (Repositories)
    // Each field that is to be autowired requires its own annotation
    @Autowired // CustomerRepo
    private CustomerRepository customerRepository;

    @Autowired // PurchaseRepo
    private PurchaseRepository purchaseRepository;


    // HANDLER METHODS
    // Method addPurchaseToCustomer
    @GetMapping("/addPurchase") //=> Action from HTML Doc
    @ResponseBody // if returning a String response
    public String addPurchaseToCustomer(int customerId, String item, double amount) {

        // getting customer by id
        // Must use Optional type
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            /* First, create a new purchase object */
            //Purchase newPurchase = new Purchase(item,amount);
            Purchase newPurchase1 = new Purchase();

            newPurchase1.setItemDescription(item);
            newPurchase1.setPurchaseAmount(amount);

            // Adding purchase to customer
            Customer customer = customerOptional.get();
            // add item to list
            customer.addPurchase(newPurchase1);
            /* Note: not great encapsulation... directly manipulating the list
            that is inside customer (fix later).  But, on the plus side, no
            possible side-effects here since this is the only part of the
            code with this exact object reference. */

            /* Now, save the new information into the each repository */
            purchaseRepository.save(newPurchase1); // add
            customerRepository.save(customer); // update

            return "Successfully added purchase";
        } else
            return "Customer id " + customerId + " is not valid - not in database";
    } // end method addPurchaseToCustomer
} // end PurchaseMvcController
