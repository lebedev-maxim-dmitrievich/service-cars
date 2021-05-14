package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.InvalidateDataCarException;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;
import ru.lebedev.servicecars.service.impl.CarServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Car> response = carServiceImpl.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CarRequest carRequest, Errors errors) throws InvalidateDataCarException {
        if (errors.hasErrors()) {
            throw new InvalidateDataCarException("incorrect data");
        }
        CarResponse response = carServiceImpl.create(carRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) throws CarNotFoundException {
        CarResponse response = carServiceImpl.read(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody @Valid CarRequest carRequest) throws CarNotFoundException {
        CarResponse response = carServiceImpl.update(carRequest, id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws CarNotFoundException {
        carServiceImpl.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}