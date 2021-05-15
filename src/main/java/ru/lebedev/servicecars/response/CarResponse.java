package ru.lebedev.servicecars.response;

import lombok.Data;

@Data
public class CarResponse {

    private Integer id;
    private String brande;
    private String status;
    private String model;
    private double mileage;
    private int yearProduction;
    private double costPerMinute;
    private String number;
    private byte[] photo;
}
