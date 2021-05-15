package ru.lebedev.servicecars.mapper;

import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.model.Car;
import ru.lebedev.servicecars.request.CarRequest;
import ru.lebedev.servicecars.response.CarResponse;

@Service
public class CarMapper {

    public CarResponse mapToCarResponse(Car car) {
        CarResponse carResponse = new CarResponse();
        carResponse.setId(car.getId());
        carResponse.setBrande(car.getBrande());
        carResponse.setModel(car.getModel());
        carResponse.setStatus(car.getStatus());
        carResponse.setMileage(car.getMileage());
        carResponse.setYearProduction(car.getYearProduction());
        carResponse.setCostPerMinute(car.getCostPerMinute());
        carResponse.setNumber(car.getNumber());
        carResponse.setPhoto(car.getPhoto());

        return carResponse;
    }

    public Car mapToCar(CarRequest carRequest) {
        Car car = new Car();
        car.setBrande(carRequest.getBrande());
        car.setModel(carRequest.getModel());
        car.setStatus(carRequest.getStatus());
        car.setMileage(carRequest.getMileage());
        car.setYearProduction(carRequest.getYearProduction());
        car.setCostPerMinute(carRequest.getCostPerMinute());
        car.setNumber(carRequest.getNumber());
        car.setPhoto(carRequest.getPhoto());

        return car;
    }

    public Car mergeIntoCar(CarRequest carRequest, Car car) {
        car.setBrande(carRequest.getBrande());
        car.setBrande(carRequest.getBrande());
        car.setModel(carRequest.getModel());
        car.setStatus(carRequest.getStatus());
        car.setMileage(carRequest.getMileage());
        car.setYearProduction(carRequest.getYearProduction());
        car.setCostPerMinute(carRequest.getCostPerMinute());
        car.setNumber(carRequest.getNumber());
        car.setPhoto(carRequest.getPhoto());

        return car;
    }
}
