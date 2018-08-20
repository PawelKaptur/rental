package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import com.capgemini.types.WorkerTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTest {

    @Autowired
    private CarService carService;

    @Autowired
    private WorkerService workerService;

    @Test
    @Transactional
    public void shouldFindCarById() {
        //given
        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO savedCar = carService.addCar(car);

        //when
        CarTO selectedCar = carService.findCarById(savedCar.getId());

        //then
        assertThat(savedCar.getBrand()).isEqualTo(selectedCar.getBrand());
        assertThat(savedCar.getId()).isEqualTo(selectedCar.getId());
    }

    @Test
    @Transactional
    public void shouldFindCarByBrand() {
        //given
        String brand = "BMW";
        CarTO car = new CarTOBuilder().withBrand(brand).withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTOBuilder().withBrand(brand).withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car3 = new CarTOBuilder().withBrand("nieAudi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.addCar(car);
        carService.addCar(car2);
        carService.addCar(car3);

        //when
        List<CarTO> cars = carService.findCarByBrand(brand);

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream().anyMatch(c -> c.getBrand().equals(brand))).isTrue();
    }

    @Test
    @Transactional
    public void shouldDeleteCarById() {
        //given
        String brand = "Audi";
        CarTO car = new CarTOBuilder().withBrand(brand).withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTOBuilder().withBrand(brand).withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car3 = new CarTOBuilder().withBrand(brand).withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.addCar(car);
        carService.addCar(car2);
        CarTO car3TO = carService.addCar(car3);

        //when
        carService.deleteCar(car3TO.getId());
        List<CarTO> cars = carService.findCarByBrand(brand);

        //then
        assertThat(carService.findCarById(car3TO.getId())).isNull();
        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    public void shouldUpdateCar() {
        //given
        String color = "White";
        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO savedCar = carService.addCar(car);

        //when
        CarTO selectedCar = carService.findCarById(savedCar.getId());
        selectedCar.setColor(color);
        carService.updateCar(selectedCar);

        //then
        assertThat(carService.findCarById(selectedCar.getId()).getColor()).isEqualTo(color);
        assertThat(carService.findCarById(selectedCar.getId()).getDateOfEditing()).isNotNull();
    }

    @Test
    @Transactional
    public void shouldFindCarByTypeAndBrand() {
        //given
        String brand = "Fiat";
        String type = "sedan";
        CarTO car = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car3 = new CarTOBuilder().withBrand("BMW").withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car4 = new CarTOBuilder().withBrand(brand).withType("kombi")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.addCar(car);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);

        //when
        List<CarTO> cars = carService.findCarByTypeAndBrand(type, brand);

        //then
        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    public void shouldDeleteAllCarsFromRepository() {
        //given
        String brand = "Audi";
        String type = "sedan";
        CarTO car = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.addCar(car);
        carService.addCar(car2);

        //when
        carService.deleteAll();
        List<CarTO> cars = carService.findAllCars();

        //then
        assertThat(cars).isEmpty();
    }

    @Test
    @Transactional
    public void shouldAddWardenToCar() {
        //given
        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO savedCar = carService.addCar(car);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        carService.addWardenToCar(savedCar, savedWorker);
        List<WorkerTO> workers = carService.findWorkersByCar(carService.findCarById(savedCar.getId()));

        //then
        assertThat(workers.size()).isEqualTo(1);
        assertThat(workerService.findWorkerById(savedWorker.getId()).getCars().get(0)).isEqualTo(savedCar.getId());
    }

    @Test
    @Transactional
    public void shouldFindCarsByWarden() {
        //given
        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO savedCar = carService.addCar(car);
        CarTO savedCar2 = carService.addCar(car);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        carService.addWardenToCar(savedCar, savedWorker);
        carService.addWardenToCar(savedCar2, savedWorker);
        List<CarTO> cars = carService.findCarsByWarden(workerService.findWorkerById(savedWorker.getId()));

        //then
        assertThat(cars.size()).isEqualTo(2);
    }
}
