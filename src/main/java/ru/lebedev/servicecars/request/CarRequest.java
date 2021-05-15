package ru.lebedev.servicecars.request;

import lombok.Data;
import ru.lebedev.servicecars.constant.CarRequestConstants;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class CarRequest implements CarRequestConstants {

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
