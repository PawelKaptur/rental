package com.capgemini.service;

import com.capgemini.types.CarTO;

import java.util.List;

public interface CarService {
    List<CarTO> findCarByBrand(String brand);

    CarTO findCarById(Long id);

    CarTO addCar(CarTO car);

    void deleteCar(Long id);

    CarTO updateCar(CarTO car);

    List<CarTO> findAllCars();

    List<CarTO> findCarByTypeAndBrand(String type, String brand);

    void deleteAll();
}
