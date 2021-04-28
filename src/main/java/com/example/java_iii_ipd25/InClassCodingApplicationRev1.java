package com.example.java_iii_ipd25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class InClassCodingApplicationRev1 implements ApplicationContextAware {
    public static ApplicationContext ctx;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }


    public static void main(String[] args) {
        SpringApplication.run(InClassCodingApplicationRev1.class, args);
        // Creating instances of ConsoleView and CustomerDatabase
//        ConsoleView view = new ConsoleView();
//        // CustomerDatabase customerDatabase = new ListBasedDatabase(); // Parent = >  newChild  DB using List <Object>
//        CustomerDatabase customerDatabase = new CoolHibernateDatabase(); // New DB Hibernate Framework
//
//        // Instance of MyController Class
//        MyController controller = new MyController();
//        // calling method to construct (Configure) myController
//        controller.configure(view, customerDatabase);
//
//        // Loop
//        boolean continueLoop = true;
//        while (continueLoop) {
//            continueLoop = controller.getAndDoNextAction(); // exit when method return false => EXIT
//        } // end while loop
//
//        System.out.println("Thanks. Bye.");

    } // end main method

} // end InClassCodingApplication

