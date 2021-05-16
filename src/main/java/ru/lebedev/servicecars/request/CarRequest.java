package ru.lebedev.servicecars.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class CarRequest {

    private final String REG_EX_NUMBER = "^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
    private final int CURRENT_YEAR = 2021;

    @NotEmpty
    private String brande;
    @NotEmpty
    private String model;
    @Min(0)
    @Max(500000)
    private double mileage;
    @Min(2010)
    @Max(CURRENT_YEAR)
    private int yearProduction;
    @Min(5)
    private double costPerMinute;
    @NotEmpty
    @Pattern(regexp = REG_EX_NUMBER)
    private String number;
    private byte[] photo;
}
