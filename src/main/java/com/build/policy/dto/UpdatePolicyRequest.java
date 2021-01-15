package com.build.policy.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class UpdatePolicyRequest {

    @NotEmpty(message = "Initial date cannot be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate initalDate;

    @NotEmpty(message = "Initial date cannot be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate finalDate;

    @NotEmpty(message = "Customer id cannot be empty")
    private String customerId;

    @NotEmpty(message = "Licence plate cannot be empty")
    private String licencePlate;

    @NotEmpty(message = "Price cannot be empty")
    @NumberFormat
    private Double price;

    public UpdatePolicyRequest() {}

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
