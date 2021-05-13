package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.NumberNotCorrectException;
import ru.lebedev.servicecars.exception.OldCarException;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;
import ru.lebedev.servicecars.service.impl.CarServiceImpl;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody CarRequest carRequest) throws OldCarException, NumberNotCorrectException {
        CarResponse response = carServiceImpl.create(carRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(
            @PathVariable Integer id,
            @RequestBody CarRequest carRequest) throws OldCarException, NumberNotCorrectException {
        CarResponse response = carServiceImpl.update(carRequest, id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        carServiceImpl.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) throws CarNotFoundException {
        CarResponse response = carServiceImpl.get(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
