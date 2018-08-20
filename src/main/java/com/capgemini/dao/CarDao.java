package com.capgemini.dao;

import com.capgemini.domain.CarEntity;

import java.util.Date;
import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {

    List<CarEntity> findCarByBrand(String brand);

    List<CarEntity> findCarByTypeAndBrand(String type, String brand);

    List<CarEntity> findCarsRentedBetween(Date startDate, Date endDate);

    List<CarEntity> findCarsRentedByMoreThanTenClients();

    List<CarEntity> findCarByBrandCriteriaApi(String brand);
}
