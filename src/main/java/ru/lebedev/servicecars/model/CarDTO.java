package ru.lebedev.servicecars.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "brande")
    private String brande;
    @Column(name = "model")
    private String model;
    @Column(name = "mileage")
    private double mileage;
    @Column(name = "yearProduction")
    private int yearProduction;
    @Column(name = "cost")
    private double cost;

    public String getBrande() {
        return brande;
    }

    public void setBrande(String brande) {
        this.brande = brande;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", brande='" + brande + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", yearProduction=" + yearProduction +
                ", cost=" + cost +
                '}';
    }
}
