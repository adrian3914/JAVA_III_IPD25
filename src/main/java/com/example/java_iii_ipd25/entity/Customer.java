package com.example.java_iii_ipd25.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    // Instance fields => Why not private, we are not using abstraction here ask teacher??
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String address;

    // Adding our first reference field ** Magic happens here @Relation ship
    @OneToMany
    List<Purchase> purchases;

    // Constructor
    public Customer(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Customer() {

    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setters for our ref field


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchase) {
        this.purchases = purchase;
    }

    // Method to add a purchase object to our List<E>
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

}
