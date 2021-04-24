package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.exception.PostMethodException;
import ru.lebedev.servicecars.exception.PutMethodException;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.dto.CarDTO;
import ru.lebedev.servicecars.repository.CarRepository;

import java.util.Optional;

@RestController
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
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
            return carRepository.save(car);
        }
        throw new PostMethodException();
    }

    @PutMapping
    public Car updateCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setBrande(carDTO.getBrande());
        car.setCost(carDTO.getCost());
        car.setMileage(carDTO.getMileage());
        car.setModel(carDTO.getModel());
        car.setYearProduction(carDTO.getYearProduction());
        if (checkDataCarForEmptiness(car)) {
            return carRepository.save(car);
        }
        throw new PutMethodException();
    }

    @GetMapping
    public Optional<Car> getCar(@RequestBody CarDTO carDTO) {
        return carRepository.findById(carDTO.getId());
    }

    @DeleteMapping
    public boolean deleteCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        carRepository.deleteById(car.getId());
        return true;
    }

    private boolean checkDataCarForEmptiness(Car car) {
        return car.getBrande() != null && car.getModel() != null && !(car.getCost() <= 0.0) &&
                !car.getBrande().equals("") && !car.getModel().equals("");
    }
}
