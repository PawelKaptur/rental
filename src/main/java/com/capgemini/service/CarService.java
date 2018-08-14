package com.capgemini.service;

import com.capgemini.types.CarTO;

import java.util.List;

public interface CarService {
    List<CarTO> findCarByBrand(String brand);

    CarTO findCarById(Long id);

    CarTO saveCar(CarTO car);

    void deleteCar(Long id);

    CarTO updateCar(CarTO car);

    List<CarTO> findAllCars();
}
