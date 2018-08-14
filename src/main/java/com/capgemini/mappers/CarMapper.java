package com.capgemini.mappers;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarEntity toCarEntity(CarTO carTO){
        if(carTO == null){
            return null;
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(carTO.getBrand());
        carEntity.setCarType(carTO.getCarType());
        carEntity.setColor(carTO.getColor());
        carEntity.setCourse(carTO.getCourse());
        carEntity.setEngineCapacity(carTO.getEngineCapacity());
        carEntity.setModel(carTO.getModel());
        carEntity.setPower(carTO.getPower());
        carEntity.setProductionYear(carTO.getProductionYear());

        return carEntity;
    }

    public static CarTO toCarTO(CarEntity carEntity) {
        if(carEntity == null){
            return null;
        }

        return new CarTO.CarTOBuilder().withBrand(carEntity.getBrand()).withId(carEntity.getId()).withDateOfCreating(carEntity.getDateOfCreating())
                .withCarType(carEntity.getCarType()).withColor(carEntity.getColor()).withCourse(carEntity.getCourse()).withEngineCapacity(carEntity.getEngineCapacity())
                .withModel(carEntity.getModel()).withPower(carEntity.getPower()).withProductionYear(carEntity.getProductionYear())
                .withDateOfEditing(carEntity.getDateOfEditing()).build();
    }

    public static List<CarTO> toCarTOList(List<CarEntity> carsByBrand) {
        return carsByBrand.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
    }
}
