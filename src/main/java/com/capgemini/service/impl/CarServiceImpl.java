package com.capgemini.service.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carRepository;

    @Override
    public List<CarEntity> findCarByBrand(String brand) {
        List<CarEntity> cars = carRepository.findCarByBrand(brand);
        return cars;
    }

    @Override
    public CarTO findCarById(Long id){
        return CarMapper.toCarTo(carRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public CarTO saveCar(CarTO car) {
        CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(car));
        return CarMapper.toCarTo(carEntity);
    }
}
