package ru.lebedev.servicecars.response;

import lombok.Data;

@Data
public class CarResponse {

    private Integer id;
    private String brande;
    private String model;
    private double mileage;
    private int yearProduction;
    private String number;
    private byte[] photo;
}
