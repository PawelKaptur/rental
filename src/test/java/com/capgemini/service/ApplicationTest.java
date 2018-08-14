package com.capgemini.service;

import com.capgemini.domain.CarEntity;
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
        CarEntity car = new CarEntity();
        car.setBrand("Audi");
        carService.saveCar(car);

        //when
        CarEntity selectedCar = carService.findCarById(car.getId());

        System.out.println(selectedCar);
        //then
        assertThat(car.getBrand()).isEqualTo(selectedCar.getBrand());
    }

    @Test
    public void shouldFindCarByBrand(){

        //given
        CarEntity car = new CarEntity();
        car.setBrand("Audi");
        CarEntity car2 = new CarEntity();
        car2.setBrand("Audi");
        carService.saveCar(car);
        carService.saveCar(car2);


        //when
        List<CarEntity> cars = carService.findCarByBrand("Audi");

        //then
        assertThat(cars.size()).isEqualTo(2);
    }
}
