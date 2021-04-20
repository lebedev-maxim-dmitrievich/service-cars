package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.exception.GetMethodException;
import ru.lebedev.servicecars.exception.PostMethodException;
import ru.lebedev.servicecars.exception.PutMethodException;
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
    public Optional<CarDTO> addCar(@RequestBody CarDTO body) {
        if (body != null) {
            CarDTO carDTO = body;
            if (checkDataCarForEmptiness(carDTO)) {
                carRepository.save(carDTO);

                return carRepository.findById(carDTO.getId());
            }
        }
        throw new PostMethodException();
    }

    @PutMapping
    public Optional<CarDTO> updateCar(@RequestBody CarDTO body) {
        if (body != null) {
            CarDTO carDTO = body;
            if (checkDataCarForEmptiness(carDTO)) {
                carRepository.save(carDTO);
                return carRepository.findById(carDTO.getId());
            }
        }
        throw new PutMethodException();
    }

    @GetMapping
    public Optional<CarDTO> getCar(@RequestBody CarDTO body) {
        if (body != null) {
            CarDTO carDTO = body;
            return carRepository.findById(carDTO.getId());
        }
        throw new GetMethodException();
    }

    @DeleteMapping
    public boolean deleteCar(@RequestBody CarDTO body) {
        if (body != null) {
            CarDTO carDTO = body;
            carRepository.deleteById(carDTO.getId());
            return true;
        }
        return false;
    }

    private boolean checkDataCarForEmptiness(CarDTO carDTO) {
        return carDTO.getBrande() != null && carDTO.getModel() != null && !(carDTO.getCost() <= 0.0) &&
                !carDTO.getBrande().equals("") && !carDTO.getModel().equals("");
    }
}
