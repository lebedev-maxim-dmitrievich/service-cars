package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.dao.impl.CarService;
import ru.lebedev.servicecars.dto.CarDTO;
import ru.lebedev.servicecars.exception.PostMethodException;
import ru.lebedev.servicecars.exception.PutMethodException;
import ru.lebedev.servicecars.model.Car;

import java.util.Optional;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car addCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setBrande(carDTO.getBrande());
        car.setCost(carDTO.getCost());
        car.setMileage(carDTO.getMileage());
        car.setModel(carDTO.getModel());
        car.setYearProduction(carDTO.getYearProduction());

        if (checkDataCarForEmptiness(car)) {
            return carService.save(car);
        }
        throw new PostMethodException();
    }

    @PutMapping
    public Car updateCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setBrande(carDTO.getBrande());
        car.setCost(carDTO.getCost());
        car.setMileage(carDTO.getMileage());
        car.setModel(carDTO.getModel());
        car.setYearProduction(carDTO.getYearProduction());

        if (checkDataCarForEmptiness(car)) {
            return carService.save(car);
        }
        throw new PutMethodException();
    }

    @GetMapping
    public Optional<Car> getCar(@RequestBody CarDTO carDTO) {
        return carService.get(carDTO.getId());
    }

    @DeleteMapping
    public boolean deleteCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        carService.delete(car);
        return true;
    }

    private boolean checkDataCarForEmptiness(Car car) {
        return car.getBrande() != null && car.getModel() != null && !(car.getCost() <= 0.0) &&
                !car.getBrande().equals("") && !car.getModel().equals("");
    }
}
