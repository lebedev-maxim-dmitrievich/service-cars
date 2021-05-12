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
        carResponse.setMileage(car.getMileage());
        carResponse.setModel(car.getModel());
        carResponse.setBrande(car.getBrande());
        carResponse.setNumber(car.getNumber());
        carResponse.setYearProduction(car.getYearProduction());
        carResponse.setPhoto(car.getPhoto());

        return carResponse;
    }

    public Car mapToCar(CarRequest carRequest) {
        Car car = new Car();
        car.setBrande(carRequest.getBrande());
        car.setNumber(carRequest.getNumber());
        car.setMileage(carRequest.getMileage());
        car.setModel(carRequest.getModel());
        car.setYearProduction(carRequest.getYearProduction());
        car.setPhoto(carRequest.getPhoto());

        return car;
    }

    public Car mergeIntoCar(CarRequest carRequest, Car car) {
        car.setBrande(carRequest.getBrande());
        car.setNumber(carRequest.getNumber());
        car.setMileage(carRequest.getMileage());
        car.setModel(carRequest.getModel());
        car.setYearProduction(carRequest.getYearProduction());
        car.setPhoto(carRequest.getPhoto());

        return car;
    }
}
