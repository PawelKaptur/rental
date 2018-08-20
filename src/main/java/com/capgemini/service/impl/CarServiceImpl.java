package com.capgemini.service.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.RentalDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentalEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.service.WorkerService;
import com.capgemini.types.CarTO;
import com.capgemini.types.RentalTO;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private CarDao carRepository;
    private WorkerService workerService;
    private WorkerDao workerRepository;
    private RentalDao rentalRepository;

    @Autowired
    public CarServiceImpl(CarDao carRepository, WorkerService workerService, WorkerDao workerRepository, RentalDao rentalRepository) {
        this.carRepository = carRepository;
        this.workerService = workerService;
        this.workerRepository = workerRepository;
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<CarTO> findCarByBrand(String brand) {
        return CarMapper.toCarTOList(carRepository.findCarByBrand(brand));
    }

    @Override
    public CarTO findCarById(Long id){
        return CarMapper.toCarTO(carRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public CarTO addCar(CarTO car) {
        CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(car));
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteCar(Long id) {
        carRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = false)
    public CarTO updateCar(CarTO car) {
        CarEntity carEntity = carRepository.update(CarMapper.toCarEntity(car));
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    public List<CarTO> findAllCars() {
        return CarMapper.toCarTOList(carRepository.findAll());
    }

    @Override
    public List<CarTO> findCarByTypeAndBrand(String type, String brand) {
        return CarMapper.toCarTOList(carRepository.findCarByTypeAndBrand(type, brand));
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void addWardenToCar(CarTO car, WorkerTO worker) {
        List<WorkerTO> workers = findWorkersByCar(car);
        List<WorkerEntity> workersEntities = new ArrayList<>();

        for(WorkerTO w: workers){
            workersEntities.add(workerRepository.findOne(w.getId()));
        }

        CarEntity carEntity = carRepository.findOne(car.getId());
        WorkerEntity addedWorker = workerRepository.findOne(worker.getId());
        List<CarEntity> carEntities = addedWorker.getCars();
        if(carEntities == null){
            carEntities = new ArrayList<>();
        }
        carEntities.add(carEntity);
        addedWorker.setCars(carEntities);

        workerRepository.update(addedWorker);
        workersEntities.add(addedWorker);
        carEntity.setWardens(workersEntities);

        carRepository.update(carEntity);
    }

    @Override
    public List<WorkerTO> findWorkersByCar(CarTO car) {
        List<Long> workers;
        if(car.getWardensId() != null){
            workers = car.getWardensId();
        }
        else {
            workers = new LinkedList<>();
        }

        List<WorkerTO> workersTO = new ArrayList<>();

        for(Long id: workers){
            workersTO.add(workerService.findWorkerById(id));
        }

        return workersTO;
    }

    @Override
    public List<CarTO> findCarsByWarden(WorkerTO worker) {
        List<Long> cars;
        List<CarTO> carsTO = new ArrayList<>();

        if(worker.getCars() != null){
            cars = worker.getCars();
        }
        else {
            cars = new LinkedList<>();
        }

        for(Long id: cars){
            carsTO.add(findCarById(id));
        }

        return carsTO;
    }

    @Override
    @Transactional(readOnly = false)
    public void addRentalToCar(CarTO car, RentalTO rental) {
        RentalEntity rentalEntity = rentalRepository.findOne(rental.getId());
        CarEntity carEntity = carRepository.findOne(car.getId());
        //moze od razu klient, i outpost startowy, ale to pozniej, tera kaskade sprobowac

        rentalEntity.setCarId(carEntity);
        rentalRepository.update(rentalEntity);

        List<RentalEntity> rentalEntities;
        if(carEntity.getRentals() == null){
            rentalEntities = new ArrayList<>();
        }
        else{
            rentalEntities = carEntity.getRentals();
        }

        rentalEntities.add(rentalEntity);

        carEntity.setRentals(rentalEntities);
        carRepository.update(carEntity);
    }
}
