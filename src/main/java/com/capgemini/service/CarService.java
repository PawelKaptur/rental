package com.capgemini.service;

import com.capgemini.entity.CarEntity;

import java.util.List;

public interface CarService {

    List<CarEntity> findCarByBrand(String brand);

    CarEntity findCarById(Long id);

    CarEntity saveCar(CarEntity car);
}
