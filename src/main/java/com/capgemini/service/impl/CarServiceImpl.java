package com.capgemini.service.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.service.WorkerService;
import com.capgemini.types.CarTO;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    private CarDao carRepository;
    private WorkerService workerService;

    @Autowired
    public CarServiceImpl(CarDao carRepository, WorkerService workerService) {
        this.carRepository = carRepository;
        this.workerService = workerService;
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
    public void addWardenToCar(CarTO carTO, WorkerTO workerTO) {
        //to koniecznie zmienic
/*        List<WorkerTO> workers = findWorkersByOutpost(outpost);
        List<WorkerTo>

        workers.add(worker);
        //outpost.setWorkers(workers);
        outpost.setWorkers(workers.stream().map(w -> w.getId()).collect(Collectors.toList()));
        outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));*/
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

        List<WorkerTO> workersTO = new ArrayList<>(); // = workerService.findAllWorkers().stream().filter(w -> w.getId() == workers.stream().findAny())

        for(Long id: workers){
            workersTO.add(workerService.findWorkerById(id));
        }

        return workersTO;
    }


}
