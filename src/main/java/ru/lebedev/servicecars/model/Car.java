package ru.lebedev.servicecars.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brande;
    private String model;
    private double mileage;
    @Column(name = "year_production")
    private int yearProduction;
    private String number;
    @JsonAlias("photo_car")
    private byte[] photo;
}
