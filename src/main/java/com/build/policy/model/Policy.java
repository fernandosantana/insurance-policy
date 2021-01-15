package com.build.policy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Policy {

    @Id
    private String id;
    private Long number;
    private String licencePlate;
    private Double price;
    private LocalDate initalDate;
    private LocalDate finalDate;
    private Customer customer;
    private boolean hasExpired;
    private int daysToExpire;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getInitalDate() {
        return initalDate;
    }

    public void setInitalDate(LocalDate initalDate) {
        this.initalDate = initalDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isHasExpired() {
        return hasExpired;
    }

    public void setHasExpired(boolean hasExpired) {
        this.hasExpired = hasExpired;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
