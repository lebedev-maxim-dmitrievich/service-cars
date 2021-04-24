package ru.lebedev.servicecars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lebedev.servicecars.model.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
}
