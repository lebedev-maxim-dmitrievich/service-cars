package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.mapper.CarMapper;
import ru.lebedev.servicecars.service.CarService;
import ru.lebedev.servicecars.dto.CarDto;
import ru.lebedev.servicecars.model.Car;

@RestController
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping("/api/cars")
    public ResponseEntity addCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.save(car);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PutMapping("/api/cars")
    public ResponseEntity updateCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.save(car);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/api/cars")
    public ResponseEntity getCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);

        return new ResponseEntity<>(carService.get(car.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/api/cars")
    public ResponseEntity deleteCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.delete(car);

        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }
}
