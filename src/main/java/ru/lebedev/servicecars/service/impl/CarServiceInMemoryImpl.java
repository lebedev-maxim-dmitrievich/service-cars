package ru.lebedev.servicecars.service.impl;

import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.model.CarDTO;
import ru.lebedev.servicecars.service.CarService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarServiceInMemoryImpl implements CarService {

    private Map<Integer, CarDTO> cars = new HashMap<>();

    @Override
    public void addCar(int id, String brande, String model, double mileage, int yearProduction, double cost) {
        cars.put(id, new CarDTO(id, brande, model, mileage, yearProduction, cost));
    }

    @Override
    public CarDTO getCar(int id) {
        return cars.get(id);
    }
}
