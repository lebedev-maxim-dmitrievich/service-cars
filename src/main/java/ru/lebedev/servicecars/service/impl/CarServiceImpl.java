package ru.lebedev.servicecars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.exception.CarNotFoundException;
import ru.lebedev.servicecars.exception.NumberNotCorrectException;
import ru.lebedev.servicecars.exception.OldCarException;
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
import java.util.regex.Pattern;

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
    public CarResponse get(int id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException("Car not found");
        }
        CarResponse response = carMapper.mapToCarResponse(carOptional.get());

        return response;
    }

    @Override
    public CarResponse update(CarRequest carRequest, int id) throws OldCarException, NumberNotCorrectException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new EntityNotFoundException("Car not found");
        }
        Car car = carOptional.get();
        Car requestCar = carMapper.mapToCar(carRequest);
        checkSuitability(requestCar);
        carRepository.save(carMapper.mergeIntoCar(carRequest, car));
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public CarResponse create(CarRequest carRequest) throws NumberNotCorrectException, OldCarException {
        Car car = carMapper.mapToCar(carRequest);
        checkSuitability(car);
        carRepository.save(car);
        CarResponse response = carMapper.mapToCarResponse(car);

        return response;
    }

    @Override
    public void delete(int id) {
        carRepository.delete(carRepository.getOne(id));
    }

    private void checkSuitability(Car car) throws NumberNotCorrectException, OldCarException {

        if (car.getYearProduction() < 2005) {
            throw new OldCarException("The car's year of manufacture is too old");
        }

        if (!checkCorrectnessNumber(car.getNumber())) {
            throw new NumberNotCorrectException("The car number is incorrect");
        }
    }

    private boolean checkCorrectnessNumber(String number) {
        String regex = "^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
        return Pattern.matches(regex, number);
    }
}
