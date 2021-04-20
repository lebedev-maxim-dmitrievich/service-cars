package ru.lebedev.servicecars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lebedev.servicecars.model.CarDTO;

@Repository
public interface CarRepository extends JpaRepository<CarDTO, Integer> {
}
