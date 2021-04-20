package ru.lebedev.servicecars.service;

import ru.lebedev.servicecars.model.CarDTO;

public interface CarService {
    void addCar(int id, String brande, String model, double mileage, int yearProduction, double cost);

    CarDTO getCar(int id);
}
