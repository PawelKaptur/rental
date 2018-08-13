package com.capgemini;


import com.capgemini.entity.CarEntity;
import com.capgemini.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private CarService carService;

    @Test
    public void shouldFindCarById(){

        //given
        CarEntity car = new CarEntity();
        car.setBrand("Audi");
        car.setId(55L);
        carService.saveCar(car);

        //when
        CarEntity selectedCar = carService.findCarById(car.getId());

        //then
    //    assertThat(car.getBrand()).isEqualTo(selectedCar.getBrand());
    }
}
