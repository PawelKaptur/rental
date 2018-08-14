package com.capgemini.dao;

import com.capgemini.domain.CarEntity;

import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {

    List<CarEntity> findCarByBrand(String brand);
    List<CarEntity> findCarByTypeAndBrand(String type, String brand);
}
