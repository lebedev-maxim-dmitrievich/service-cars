package ru.lebedev.servicecars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.repository.CarDao;
import ru.lebedev.servicecars.service.impl.CarServiceImpl;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService implements CarServiceImpl {

    private final CarDao carRepository;

    @Autowired
    public CarService(CarDao carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car get(Integer id) {
        return carRepository.findById(id).get();
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
