package ru.lebedev.servicecars.mapper;

import org.springframework.stereotype.Service;
import ru.lebedev.servicecars.dto.CarDto;
import ru.lebedev.servicecars.model.Car;

@Service
public class CarMapper {

    public Car mapToCar(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setBrande(carDto.getBrande());
        car.setCost(carDto.getCost());
        car.setMileage(carDto.getMileage());
        car.setModel(carDto.getModel());
        car.setYearProduction(carDto.getYearProduction());
        car.setImageBase64(carDto.getImageBase64());

        return car;
    }
}
