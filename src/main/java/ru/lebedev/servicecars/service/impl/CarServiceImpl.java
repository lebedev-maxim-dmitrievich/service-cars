package ru.lebedev.servicecars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.mapper.CarMapper;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.repository.CarRepository;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;
import ru.lebedev.servicecars.service.CarService;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<CarResponse> getAll() {
        List<CarResponse> carResponses = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            carResponses.add(carMapper.mapToCarResponse(car));
        }
        return carResponses;
    }

    @Override
    public CarResponse create(CarRequest carRequest) {
        Car car = carMapper.mapToCar(carRequest);
        carRepository.save(car);
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public CarResponse read(int id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException("car not found");
        }
        CarResponse response = carMapper.mapToCarResponse(carOptional.get());

        return response;
    }

    @Override
    public CarResponse update(CarRequest carRequest, int id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException("car not found");
        }
        Car car = carOptional.get();
        carRepository.save(carMapper.mergeIntoCar(carRequest, car));
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public void delete(int id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException("car not found");
        }
        carRepository.delete(carRepository.getOne(id));
    }
}
