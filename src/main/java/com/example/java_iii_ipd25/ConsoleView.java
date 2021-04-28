package com.example.java_iii_ipd25;




import com.example.java_iii_ipd25.entity.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    /* Console view will take care of all the visualization with the user */
    static Scanner in = new Scanner(System.in);

    /* Method to ask the user what they want to do next */
    // Return Enum field(label)
    public UserChoice requestAction() {
        // Scanner in = new Scanner(System.in);
        try {
            // Promp user nex action and pass the value to Enum
            System.out.println("What would like to do next?");
            System.out.println(" 1. Add new Customer"); // => C -> CREATE
            System.out.println(" 2. Get Customer by id"); // => R -> READ
            System.out.println(" 3. Update Customer by id"); // U -> UPDATE
            System.out.println(" 4. Remove Customer by id"); // D -> DELETE
            System.out.println(" 5. Exit"); // => Exit application
            // Assign user value
            int choice = in.nextInt();

            // Switch to return our Enum field
            switch (choice) {
                case 1 -> {
                    return UserChoice.CREATE;
                }
                case 2 -> {
                    return UserChoice.GETBYID;
                }
                case 3 -> {
                    return UserChoice.UPDATEBYID;
                }
                case 4 -> {
                    return UserChoice.REMOVEBYID;
                }
                case 5 -> {
                    return UserChoice.EXIT;
                }
                default -> {
                    return UserChoice.NONE;
                }
            } // Switch ends here

        } catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return UserChoice.NONE;
        } // catch ends here

    } // requestAction method ends here


    // getCustomer method to initialize our object => returns null if not entered properly
    public Customer getCustomer() {
        Scanner in = new Scanner(System.in);
        try {
            // prompt user to enter name, age, id and address values to be assigned to our Customer object

            System.out.println("Please enter customer name");
            String name = in.nextLine();

            System.out.println("Please enter customer address");
            String address = in.nextLine();

            System.out.println("Please enter customer age");
            int age = in.nextInt();

//            System.out.println("Please enter customer id");
//            int id = in.nextInt();


            // Instantiating Customer class => creating object using constructor
            Customer customer = new Customer(name, age, address);
            // Returns our object customer
            return customer;

        }// try clause ends here
        catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return null; // no customer return
        } //catch ends here

    } // getCustomer method ends here

    // Ask customer id number to to be retrieved
    public int getIdToRetrieve() {
        // Scanner in = new Scanner(System.in);
        try {
            System.out.println("Please enter id of customer to retrieve");
            int id = in.nextInt();
            return id;

        } catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return 0;
        }
    } // end method getIdToRetrieve

    public int getIdToRemove() {
        // Scanner in = new Scanner(System.in);
        try {
            System.out.println("Please enter id of customer to delete");
            int id = in.nextInt();

            return id;
        } catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return 0;
        }
    } // end method getIdToRemove

    // Ask user customer id to be removed method
    public int getIdToUpdate() {
        System.out.println("Please provide customer id to be updated");
        int id = in.nextInt();
        return id;
    } // end method getIdToUpdate


    // ShowCustomer method to display to user
    public void showCustomer(Customer customer) {
        System.out.println(
                "CUSTOMER\n" +
                        "id: " + customer.getId() + "\n" +
                        "name= " + customer.getName() + "\n" +
                        "age= " + customer.getAge() + "\n" +
                        "address= " + customer.getAddress() + "\n");
    } // showCustomer method ends here
} // end method showCustomer
