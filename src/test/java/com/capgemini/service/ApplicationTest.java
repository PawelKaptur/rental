package com.capgemini.service;

import com.capgemini.types.CarTO;
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

    @Test
    public void shouldFindCarById() {

        //given
        CarTO car = new CarTO.CarTOBuilder().withBrand("Audi").withCarType("sedan")
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
    public void shouldFindCarByBrand(){

        //given
        String brand = "Audi";
        CarTO car = new CarTO.CarTOBuilder().withBrand(brand).withCarType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO car2 = new CarTO.CarTOBuilder().withBrand(brand).withCarType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        carService.saveCar(car);
        carService.saveCar(car2);

        //when
        List<CarTO> cars = carService.findCarByBrand("Audi");

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream().anyMatch(c -> c.getBrand().equals(brand))).isTrue();
    }
}
