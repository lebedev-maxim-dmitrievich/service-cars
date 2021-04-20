package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.model.CarDTO;
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
    public void addCar(@RequestBody CarDTO jsonCarDTO) {
        if (jsonCarDTO != null) {
            CarDTO carDTO = jsonCarDTO;
            carRepository.save(carDTO);
        }
    }

    @PutMapping
    public void updateCar(@RequestBody CarDTO jsonCarDTO) {
        if (jsonCarDTO != null) {
            carRepository.save(jsonCarDTO);
        }
    }

    @GetMapping
    public Optional<CarDTO> getCar(@RequestBody CarDTO jsonCarDTO) {
        return carRepository.findById(jsonCarDTO.getId());
    }

    @DeleteMapping
    public void deleteCar(@RequestBody CarDTO jsonCarDTO) {
        carRepository.deleteById(jsonCarDTO.getId());
    }
}
