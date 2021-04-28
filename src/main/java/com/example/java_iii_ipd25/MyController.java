package com.example.java_iii_ipd25;


import com.example.java_iii_ipd25.entity.Customer;

public class MyController {

    // reference fields
    private ConsoleView view; //=> ref field Class
    private CustomerDatabase customerDatabase; //=>ref field interface

    // Default constructor
    public MyController() {
    } // end controller => default


    // Method to configure controller
    public void configure(ConsoleView view, CustomerDatabase customerDatabase) {
        this.view = view;
        this.customerDatabase = customerDatabase;
    } // end method configure


    // Method to carry request based on user request
    public boolean getAndDoNextAction() {
        // Passing Enum field label chosen by the user
        UserChoice choice = view.requestAction();

        // switch to call method| exit based on choice
        switch (choice) {
            case CREATE -> {
                doCreate();
                return true;
            } // Instance of Customer Class
            case GETBYID -> {
                doGetById();
                return true;
            }
            case UPDATEBYID -> {
                doUpdateById();
                return true;
            }
            case REMOVEBYID -> {
                doRemoveById();
                return true;
            }
            case EXIT -> {
                return false;
            }
            default -> {
                return true;
            }
        } // switch ends here
    } // method getAndDoNextAction ends

    // CREATE
    // Instance of Customer Class created in ConsoleView => Method getCustomer()
    private void doCreate() {
        Customer customer = view.getCustomer();
        if (customer != null) {
            customerDatabase.save(customer);
        } else
            System.out.println("Failed to saved customer");
    } // doCreate method ends here

    // GETBYID
    // Method to getCustomer by id
    private void doGetById() {
        // Must get id number to be retrieved ask user in ConsoleView
        int id = view.getIdToRetrieve(); // returns id

        // Customer object to be returned
        Customer customer = customerDatabase.findCustomerById(id);
        if (customer != null)
            view.showCustomer(customer);
            // in case customer does not exist in db
        else {
            System.out.println("Customer with id " + id + " number does not exist in database");
            view.getIdToRetrieve();
        }
    } // end method doGetById

    public Customer doUpdateById() {
        // get customer id to be updated
        int id = view.getIdToUpdate();

        // asking the database to remove customer with id provided by user
        Customer customer = customerDatabase.removeCustomerById(id);

        // asking console view to show customer removed info
        System.out.println("Customer current information");
        view.showCustomer(customer);

        // asking ConsoleView to ask customer new information
        System.out.println("\nEnter new customer information");
        Customer updatedCustomer = view.getCustomer();

        // Asking dataBase to add updatedCustomer to ListDatabase
        if (updatedCustomer != null) {
            customerDatabase.save(updatedCustomer);
        } else {
            System.out.println("Failed to update customer");
        }
        System.out.println("Customer updated successfully");
        return updatedCustomer;
    }

    public void doRemoveById() {
        int id = view.getIdToRemove();

        Customer customer = customerDatabase.removeCustomerById(id);
        if (customer != null)
            view.showCustomer(customer);
        else {
            System.out.println("Customer with id" + id + " number does not exist database");
        }
    } // end method doRemoveById

}
