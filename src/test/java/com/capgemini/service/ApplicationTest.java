package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private CarService carService;

    @Before
    public void setUp(){
        carService.deleteAll();
    }

    @Test
    public void shouldFindCarById() {

        //given
        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO savedCar = carService.saveCar(car);

        //when
        CarTO selectedCar = carService.findCarById(savedCar.getId());

        //then
        assertThat(savedCar.getBrand()).isEqualTo(selectedCar.getBrand());
        assertThat(savedCar.getId()).isEqualTo(selectedCar.getId());
    }

    @Test
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
        carService.saveCar(car);
        carService.saveCar(car2);
        carService.saveCar(car3);

        //when
        List<CarTO> cars = carService.findCarByBrand(brand);

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream().anyMatch(c -> c.getBrand().equals(brand))).isTrue();
    }

    @Test
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
        carService.saveCar(car);
        carService.saveCar(car2);
        CarTO car3TO = carService.saveCar(car3);

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
        CarTO savedCar = carService.saveCar(car);

        //when
        CarTO selectedCar = carService.findCarById(savedCar.getId());
        selectedCar.setColor(color);
        carService.updateCar(selectedCar);

        //then
        assertThat(carService.findCarById(selectedCar.getId()).getColor()).isEqualTo(color);
        assertThat(carService.findCarById(selectedCar.getId()).getDateOfEditing()).isNotNull();
    }

    @Test
    public void shouldFindCarByTypeAndBrand() {
        //given
        String brand = "Audi";
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
        carService.saveCar(car);
        carService.saveCar(car2);
        carService.saveCar(car3);
        carService.saveCar(car4);

        //when
        List<CarTO> cars = carService.findCarByTypeAndBrand(type, brand);

        //then
        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    public void shouldDeleteAllCarsFromRepository(){
        //given
        String brand = "Audi";
        String type = "sedan";
        CarTO car = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTOBuilder().withBrand(brand).withType(type)
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.saveCar(car);
        carService.saveCar(car2);

        //when
        carService.deleteAll();
        List<CarTO> cars = carService.findAllCars();

        //then
        assertThat(cars).isEmpty();
    }

}
