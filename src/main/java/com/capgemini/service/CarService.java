package com.capgemini.service;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

import java.util.List;

public interface CarService {

    List<CarEntity> findCarByBrand(String brand);

    //CarEntity findCarById(Long id);
    CarTO findCarById(Long id);

    //CarEntity saveCar(CarEntity car);
    CarTO saveCar(CarTO car);
}
