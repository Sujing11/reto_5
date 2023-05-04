package com.usa.reto_3.repository;

import com.usa.reto_3.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {
}
