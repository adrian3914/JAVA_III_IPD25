package com.example.java_iii_ipd25.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderNumber;
    String itemDescription;
    double purchaseAmount;

    // Constructors
    // Default
    public Purchase() {
    }

    public Purchase(String itemDescription, double purchaseAmount) {
        this.itemDescription = itemDescription;
        this.purchaseAmount = purchaseAmount;
    }

    // getter and setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

}
