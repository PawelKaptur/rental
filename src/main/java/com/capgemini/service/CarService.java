package com.capgemini.service;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.*;

import java.util.Date;
import java.util.List;

public interface CarService {
    List<CarTO> findCarByBrand(String brand);

    CarTO findCarById(Long id);

    CarTO addCar(CarTO car);

    void deleteCar(Long id);

    CarTO updateCar(CarTO car);

    List<CarTO> findAllCars();

    List<CarTO> findCarByTypeAndBrand(String type, String brand);

    void deleteAll();

    void addWardenToCar(CarTO car, WorkerTO worker);

    List<WorkerTO> findWorkersByCar(CarTO car);

    List<CarTO> findCarsByWarden(WorkerTO worker);

    void createRental(CarTO car, RentalTO rental, ClientTO client);

    List<CarTO> findCarsRentedBetween(Date startDate, Date endDate);

    List<CarTO> findCarsRentedByMoreThanTenClients();

    List<CarTO> findCarByBrandCriteriaApi(String brand);
}
