package ru.lebedev.servicecars.service;

import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    CarResponse update(CarRequest carRequest, int id);
    CarResponse get(int id);
    CarResponse create(CarRequest carRequest);
    void delete(int id);
}
