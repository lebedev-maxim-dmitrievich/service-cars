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
    public void addCar(@RequestParam String brande, @RequestParam String model, @RequestParam double mileage,
                       @RequestParam int yearProduction, @RequestParam double cost) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrande(brande);
        carDTO.setModel(model);
        carDTO.setMileage(mileage);
        carDTO.setYearProduction(yearProduction);
        carDTO.setCost(cost);
        carRepository.save(carDTO);
    }

    @PutMapping
    public void updateCar(@RequestParam Integer id, @RequestParam String brande, @RequestParam String model, @RequestParam double mileage,
                          @RequestParam int yearProduction, @RequestParam double cost) {
        CarDTO carDTO = carRepository.getOne(id);
        carDTO.setBrande(brande);
        carDTO.setModel(model);
        carDTO.setMileage(mileage);
        carDTO.setYearProduction(yearProduction);
        carDTO.setCost(cost);
        carRepository.save(carDTO);
    }

    @GetMapping
    public Optional<CarDTO> getCar(@RequestParam Integer id) {
        return carRepository.findById(id);
    }

    @DeleteMapping
    public void deleteCar(@RequestParam Integer id) {
        carRepository.deleteById(id);
    }
}
