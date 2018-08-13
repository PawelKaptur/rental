package com.capgemini.dao;

import com.capgemini.entity.CarEntity;

import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {

    List<CarEntity> findCarByBrand(String brand);
}
