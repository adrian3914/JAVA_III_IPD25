package com.example.java_iii_ipd25;




import com.example.java_iii_ipd25.entity.Customer;
import com.example.java_iii_ipd25.repository.CustomerRepository;

import java.util.Optional;

// this Implements Interface CustomerDatabase
public class CoolHibernateDatabase implements CustomerDatabase {

    // customerRepository is treated like a List<Customer>
    private CustomerRepository customerRepository = InClassCodingApplicationRev1.ctx.getBean(CustomerRepository.class);


    // Saving customer to Hibernate Database => returns false if not saved
    @Override
    public boolean save(Customer customer) {

        if (customer != null) {
            if (findCustomerById(customer.getId()) == null) {
                Customer c = customerRepository.save(customer);
                System.out.println("Customer added successfully to database");
                return true;
            } else
                System.out.println("Customer already exist with ID " + customer.getId());
        }
        return false;
    } // end save method


    // Find customer in hibernate database method
    @Override
    public Customer findCustomerById(int id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            return c.get(); // return object if exist
        } else
            return null;
    } // end method findCustomerById

    @Override
    public Customer removeCustomerById(int id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            customerRepository.delete(c.get());
            return c.get();
        } else
            return null;

    } // end method removeCustomerById
} // end CoolHibernateDatabase