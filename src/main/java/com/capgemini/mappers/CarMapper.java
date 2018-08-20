package com.capgemini.mappers;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarEntity toCarEntity(CarTO carTO) {
        if (carTO == null) {
            return null;
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setId(carTO.getId());
        carEntity.setBrand(carTO.getBrand());
        carEntity.setType(carTO.getType());
        carEntity.setColor(carTO.getColor());
        carEntity.setCourse(carTO.getCourse());
        carEntity.setEngineCapacity(carTO.getEngineCapacity());
        carEntity.setModel(carTO.getModel());
        carEntity.setPower(carTO.getPower());
        carEntity.setProductionYear(carTO.getProductionYear());
        carEntity.setDateOfCreating(carTO.getDateOfCreating());

        return carEntity;
    }

    public static CarTO toCarTO(CarEntity carEntity) {
        if (carEntity == null) {
            return null;
        }

        CarTOBuilder carTOBuilder = new CarTOBuilder().withBrand(carEntity.getBrand()).withId(carEntity.getId()).withDateOfCreating(carEntity.getDateOfCreating())
                .withType(carEntity.getType()).withColor(carEntity.getColor()).withCourse(carEntity.getCourse()).withEngineCapacity(carEntity.getEngineCapacity())
                .withModel(carEntity.getModel()).withPower(carEntity.getPower()).withProductionYear(carEntity.getProductionYear())
                .withDateOfEditing(carEntity.getDateOfEditing());

        if (carEntity.getWardens() != null) {
            carTOBuilder = carTOBuilder.withWardens(carEntity.getWardens().stream().map(w -> w.getId()).collect(Collectors.toList()));
        }

        if (carEntity.getRentals() != null) {
            carTOBuilder = carTOBuilder.withRentals(carEntity.getRentals().stream().map(r -> r.getId()).collect(Collectors.toList()));
        }

        return carTOBuilder.build();
    }

    public static List<CarTO> toCarTOList(List<CarEntity> cars) {
        return cars.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
    }
}
