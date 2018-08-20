package com.capgemini.service.impl;

import com.capgemini.dao.RentalDao;
import com.capgemini.domain.RentalEntity;
import com.capgemini.mappers.RentalMapper;
import com.capgemini.service.RentalService;
import com.capgemini.types.RentalTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService {

    private RentalDao rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalDao rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public RentalTO findRentaltById(Long id) {
        return RentalMapper.toRentalTO(rentalRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public RentalTO addRental(RentalTO rental) {
        RentalEntity rentalEntity = rentalRepository.save(RentalMapper.toRentalEntity(rental));
        return RentalMapper.toRentalTO(rentalEntity);
    }
}
