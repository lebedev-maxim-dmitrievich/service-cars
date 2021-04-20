package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lebedev.servicecars.model.CarDTO;
import ru.lebedev.servicecars.service.CarService;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void addCar(@RequestParam int id, @RequestParam String brande, @RequestParam String model,
                       @RequestParam double mileage, @RequestParam int yearProduction, @RequestParam double cost) {
        carService.addCar(id, brande, model, mileage, yearProduction, cost);
    }

    @GetMapping
    public CarDTO getCar(@RequestParam int id) {
        return carService.getCar(id);
    }
}
