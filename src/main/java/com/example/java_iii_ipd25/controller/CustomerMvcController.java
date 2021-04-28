package com.example.java_iii_ipd25.controller;


import com.example.java_iii_ipd25.entity.Customer;
import com.example.java_iii_ipd25.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

// We will never instantiate this Frameworks does
@Controller
public class CustomerMvcController {

    @Autowired
    private CustomerRepository customerRespository;


    /**
     * Sample handler method for our 'Hello World' Spring MVC example
     * This method listens for the HTTP GET request for
     * the url "localhost:XXXX/hello.  This request is essentially the
     * event trigger for this handler.
     * Since this handler returns a message to be displayed on the page,
     * we need to use @ResponseBody.
     */
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(
            @RequestParam(value = "myName", defaultValue = "World")
                    String name) {
        return String.format("Hello %s!", name);
    }


    /* Returns a message to display directly on the page.
     * Since this is returning a specific "response", we use @ResponseBody */
    // Post show this in the URL: http://localhost:8082/add
    // Get shows this in the URL: http://localhost:8082/add?name=Homer&age=13
    // Method to add customer
    @PostMapping("/add")
    @ResponseBody
    public String addCustomer(String first, int age) {
        //validateEntry
        Customer customer = new Customer(first, age, "");
        customerRespository.save(customer);
        return "Added customer to repo";
    }

    // Method to get all customers via SpringController from DB to display in HTML
    @GetMapping("/list")
    public String getCustomer(ModelMap model) {
        // Retrieve the information from the database and associate it with the
        //   attribute "customers" in the model.  This attribute needs to correspond
        //   to the name used in the html file that will be loaded.
        model.addAttribute("customers", customerRespository.findAll());

        // This is the name of the html file to display (passing the info in the model).
        return "list_customers";
    }

    // Update field => name & send back String with the response to the view
    @GetMapping("/updateCustomerName")
    @ResponseBody //=> we are returning a string to show in the html doc and not opening another HTML page
    public String updateCustomerName(int id, String newName) {
        Optional<Customer> customerToChange = customerRespository.findById(id);

        // If customer with id exist do
        if (customerToChange.isPresent()) {
            // passing customerObject to be changed
            Customer customerObject = customerToChange.get();
            customerObject.setName(newName);

            // save updated Customer to DB
            customerRespository.save(customerObject);
            return "Customer has been updated successfully.";

        } else {
            // operation fails since id is invalid
            return "Customer with " + id + " does not exist";
        }
    } // method updateCustomerName ends here

} // end class SpringMvcController
