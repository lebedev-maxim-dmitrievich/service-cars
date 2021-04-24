package ru.lebedev.servicecars.dao;

import ru.lebedev.servicecars.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getAll();
    Optional<Car> get(Integer id);
    Car save(Car car);
    void delete(Car car);
}
