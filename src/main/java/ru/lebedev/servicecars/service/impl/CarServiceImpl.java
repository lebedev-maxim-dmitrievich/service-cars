package ru.lebedev.servicecars.service.impl;

import ru.lebedev.servicecars.model.Car;

import java.util.List;

public interface CarServiceImpl {
    List<Car> getAll();
    Car get(Integer id);
    Car save(Car car);
    void delete(Car car);
}
