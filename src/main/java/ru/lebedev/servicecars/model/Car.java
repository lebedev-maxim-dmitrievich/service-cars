package ru.lebedev.servicecars.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

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
    @Column(name = "cost_per_minute")
    private double costPerMinute;
    @Column(name = "photo_car", length = 83886080)
    private byte[] photo;
}
