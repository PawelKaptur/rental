package com.capgemini.service;

import com.capgemini.types.RentalTO;

public interface RentalService {
    RentalTO findRentaltById(Long id);

    RentalTO addRental(RentalTO rental);
}
