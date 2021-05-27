package ru.lebedev.servicecars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicecars.exception.*;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;
import ru.lebedev.servicecars.service.CarService;
import ru.lebedev.servicecars.service.impl.CarServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CarResponse> response = carService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CarRequest carRequest) {
        CarResponse response = carService.create(carRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) throws CarNotFoundException {
        CarResponse response = carService.get(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody @Valid CarRequest carRequest) throws CarNotFoundException, UpdateCarException {
        CarResponse response = carService.update(carRequest, id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws CarNotFoundException, DeleteCarException {
        carService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/book")
    public ResponseEntity<?> bookCar(@PathVariable Integer id) throws CarNotFoundException, StatusException {
        CarResponse response = carService.bookCar(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}/free")
    public ResponseEntity<?> freeCar(@PathVariable Integer id) throws CarNotFoundException, StatusException {
        CarResponse response = carService.freeCar(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}/repair")
    public ResponseEntity<?> repairCar(@PathVariable Integer id) throws CarNotFoundException, StatusException {
        CarResponse response = carService.repairCar(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}