package ru.lebedev.servicecars.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.dao.CarDao;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarDao {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> get(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.deleteById(car.getId());
    }
}
