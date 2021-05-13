package ru.lebedev.servicecars.service;

import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.InvalidateDataCarException;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Object update(CarRequest carRequest, int id) throws CarNotFoundException;

    CarResponse read(int id) throws InvalidateDataCarException, CarNotFoundException;

    CarResponse create(CarRequest carRequest);

    void delete(int id) throws CarNotFoundException;
}
