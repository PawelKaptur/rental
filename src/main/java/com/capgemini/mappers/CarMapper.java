package com.capgemini.mappers;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

public class CarMapper {

    public static CarEntity toCarEntity(CarTO carTO){
        if(carTO == null){
            return null;
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(carTO.getBrand());

        return carEntity;
    }

    public static CarTO toCarTo(CarEntity carEntity) {
        if(carEntity == null){
            return null;
        }

        return new CarTO.CarTOBuilder().withBrand(carEntity.getBrand()).withId(carEntity.getId()).build();
    }
}
