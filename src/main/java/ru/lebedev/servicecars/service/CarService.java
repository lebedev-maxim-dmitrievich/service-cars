package ru.lebedev.servicecars.service;

import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.NumberNotCorrectException;
import ru.lebedev.servicecars.exception.OldCarException;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Object update(CarRequest carRequest, int id) throws OldCarException, NumberNotCorrectException;
    CarResponse get(int id) throws CarNotFoundException;
    CarResponse create(CarRequest carRequest) throws NumberNotCorrectException, OldCarException;
    void delete(int id);
}
