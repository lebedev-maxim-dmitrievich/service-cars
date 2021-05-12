package ru.lebedev.servicecars.request;

import lombok.Data;

@Data
public class CarRequest {

    private String brande;
    private String model;
    private double mileage;
    private int yearProduction;
    private String number;
    private byte[] photo;
}
