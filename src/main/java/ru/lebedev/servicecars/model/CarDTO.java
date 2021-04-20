package ru.lebedev.servicecars.model;

public class CarDTO {

    private int id;
    private String brande;
    private String model;
    private double mileage;
    private int yearProduction;
    private double cost;

    public CarDTO(int id, String brande, String model, double mileage, int yearProduction, double cost) {
        this.id = id;
        this.brande = brande;
        this.model = model;
        this.mileage = mileage;
        this.yearProduction = yearProduction;
        this.cost = cost;
    }

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
}
