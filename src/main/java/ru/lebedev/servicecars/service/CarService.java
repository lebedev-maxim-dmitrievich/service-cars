package ru.lebedev.servicecars.service;

import ru.lebedev.servicecars.exception.*;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;

import java.util.List;

public interface CarService {

    List<CarResponse> getAll();

    CarResponse create(CarRequest carRequest);

    CarResponse get(int id) throws CarNotFoundException;

    CarResponse update(CarRequest carRequest, int id) throws CarNotFoundException, UpdateCarException;

    void delete(int id) throws CarNotFoundException, DeleteCarException;

    CarResponse bookCar(int id) throws CarNotFoundException, StatusException, RepairStatusException;

    CarResponse freeCar(int id) throws CarNotFoundException, StatusException;

    CarResponse repairCar(int id) throws CarNotFoundException, StatusException, RepairStatusException;

}
