package com.capgemini.service;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

import java.util.List;

public interface CarService {

    //List<CarEntity> findCarByBrand(String brand);

    List<CarTO> findCarByBrand(String brand);

    CarTO findCarById(Long id);

    CarTO saveCar(CarTO car);
}
