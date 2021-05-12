package ru.lebedev.servicecars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.mapper.CarMapper;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.repository.CarRepository;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;
import ru.lebedev.servicecars.service.CarService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public CarResponse get(int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        CarResponse response = carMapper.mapToCarResponse(carOptional.get());

        return response;
    }

    @Override
    public CarResponse update(CarRequest carRequest, int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Car car = carOptional.get();
        carRepository.save(carMapper.mergeIntoCar(carRequest, car));
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public CarResponse create(CarRequest carRequest) {
        Car car = carMapper.mapToCar(carRequest);
        carRepository.save(car);
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public void delete(int id) {
        carRepository.delete(carRepository.getOne(id));
    }
}
