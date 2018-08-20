package com.capgemini.service;


import com.capgemini.types.OutpostTO;
import com.capgemini.types.RentalTO;
import com.capgemini.types.RentalTO.RentalTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalTest {

    @Autowired
    private RentalService rentalService;

    @Test
    @Transactional
    public void shouldAddRental() {
        //given
        RentalTO rentalTO = new RentalTO().builder().cost(2000).startDate(new Date()).endDate(new Date())
                .build();

        RentalTO addedRental = rentalService.addRental(rentalTO);

        //when
        RentalTO selectedRental = rentalService.findRentaltById(addedRental.getId());

        //then
        assertThat(selectedRental.getId()).isEqualTo(addedRental.getId());
    }
}
