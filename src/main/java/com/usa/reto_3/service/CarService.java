package com.usa.reto_3.service;

import com.usa.reto_3.dbo.CarDbo;
import com.usa.reto_3.model.CarModel;
import com.usa.reto_3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> obtener(){
        return carRepository.findAll();
    }

    public Optional<CarModel> obtenerPorId(int id) {
        return carRepository.findById(id);
    }

    public void crear(CarModel car){
        if(!carRepository.existsById(car.getIdCar())){
            carRepository.save(car);
        }
    }

    public void actualizar(CarDbo carInput) {
        Optional<CarModel> carDB = carRepository.findById(carInput.getIdCar());
        if(carDB.isPresent()){
            CarModel car = carDB.get();
            if(carInput.getBrand() != null){
                car.setBrand(carInput.getBrand());
            }
            if(carInput.getName() != null){
                car.setName(carInput.getName());
            }
            if(carInput.getDescription() != null){
                car.setDescription(carInput.getDescription());
            }
            if(carInput.getYear() != null){
                car.setYear(carInput.getYear());
            }
            carRepository.save(car);
        }
    }

    public void eliminar(int id) {
        carRepository.deleteById(id);
    }

}
