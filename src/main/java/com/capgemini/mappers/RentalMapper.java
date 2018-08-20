package com.capgemini.mappers;

import com.capgemini.domain.RentalEntity;
import com.capgemini.types.RentalTO;
import com.capgemini.types.RentalTO.RentalTOBuilder;

public class RentalMapper {

    public static RentalEntity toRentalEntity(RentalTO rentalTO) {
        if (rentalTO == null) {
            return null;
        }

        RentalEntity rentalEntity = new RentalEntity();
        rentalEntity.setId(rentalTO.getId());
        rentalEntity.setCost(rentalTO.getCost());
        rentalEntity.setStartDate(rentalTO.getStartDate());
        rentalEntity.setEndDate(rentalTO.getEndDate());

        return rentalEntity;
    }


    public static RentalTO toRentalTO(RentalEntity rentalEntity) {
        if (rentalEntity == null) {
            return null;
        }

        RentalTOBuilder rentalTOBuilder = new RentalTO().builder().id(rentalEntity.getId())
                .cost(rentalEntity.getCost()).startDate(rentalEntity.getStartDate())
                .endDate(rentalEntity.getEndDate());


        if (rentalEntity.getClientId() != null) {
            rentalTOBuilder = rentalTOBuilder.clientId(rentalEntity.getClientId().getId());
        }

        if (rentalEntity.getCarId() != null) {
            rentalTOBuilder = rentalTOBuilder.carId(rentalEntity.getCarId().getId());
        }

        if (rentalEntity.getStartOutpostId() != null) {
            rentalTOBuilder = rentalTOBuilder.startOutpostId(rentalEntity.getStartOutpostId().getId());
        }

        if (rentalEntity.getEndOutpostId() != null) {
            rentalTOBuilder = rentalTOBuilder.endOutpostId(rentalEntity.getEndOutpostId().getId());
        }

        return rentalTOBuilder.build();
    }
}
