package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import com.capgemini.types.ClientTO;
import com.capgemini.types.RentalTO;
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

    @Autowired
    private RentalService rentalService;

    @Autowired
    private ClientService clientService;

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

    @Test
    @Transactional
    public void shouldAddRentalToCar() {
        //given
        RentalTO rentalTO = new RentalTO().builder().cost(2000).startDate(new Date()).endDate(new Date())
                .build();
        RentalTO addedRental = rentalService.addRental(rentalTO);

        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO addedCar = carService.addCar(car);

        ClientTO clientTO = new ClientTO().builder().dateOfBirth(new Date()).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe")
                .creditCardNumber("1234567890123456").email("seba.kox@gmailcom")
                .build();

        ClientTO addedClient = clientService.addClient(clientTO);

        //when
        carService.createRental(addedCar, addedRental, addedClient);


        //then
        assertThat(carService.findCarById(addedCar.getId()).getRentals().get(0)).isEqualTo(addedRental.getId());
        assertThat(clientService.findClientById(addedClient.getId()).getRentals().get(0)).isEqualTo(addedRental.getId());
        assertThat(rentalService.findRentaltById(addedRental.getId()).getCarId()).isEqualTo(addedCar.getId());
        assertThat(rentalService.findRentaltById(addedRental.getId()).getClientId()).isEqualTo(addedClient.getId());
    }

    @Test
    @Transactional
    public void shouldDeleteCarAndRentals() {
        //given
        RentalTO rentalTO = new RentalTO().builder().cost(2000).startDate(new Date()).endDate(new Date())
                .build();
        RentalTO addedRental = rentalService.addRental(rentalTO);
        RentalTO addedRental2 = rentalService.addRental(rentalTO);
        RentalTO addedRental3 = rentalService.addRental(rentalTO);

        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO addedCar = carService.addCar(car);

        ClientTO clientTO = new ClientTO().builder().dateOfBirth(new Date()).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe")
                .creditCardNumber("1234567890123456").email("seba.kox@gmailcom")
                .build();

        ClientTO addedClient = clientService.addClient(clientTO);

        carService.createRental(addedCar, addedRental, addedClient);
        carService.createRental(addedCar, addedRental2, addedClient);

        //when
        carService.deleteCar(addedCar.getId());

        //then
        assertThat(carService.findCarById(addedCar.getId())).isNull();
        assertThat(rentalService.findRentaltById(addedRental.getId())).isNull();
        assertThat(rentalService.findRentaltById(addedRental2.getId())).isNull();
        assertThat(rentalService.findRentaltById(addedRental3.getId())).isNotNull();
        assertThat(clientService.findClientById(addedClient.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void shouldCheckTimeForRentals() {
        //given
        Date startDate = new Date(1000L);
        Date endDate = new Date(10000L);
        RentalTO rentalTO = new RentalTO().builder().cost(2000).startDate(startDate).endDate(endDate)
                .build();
        RentalTO addedRental = rentalService.addRental(rentalTO);

        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO addedCar = carService.addCar(car);

        ClientTO clientTO = new ClientTO().builder().dateOfBirth(new Date()).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe")
                .creditCardNumber("1234567890123456").email("seba.kox@gmailcom")
                .build();

        ClientTO addedClient = clientService.addClient(clientTO);

        //when
        carService.createRental(addedCar, addedRental, addedClient);


        List<CarTO> cars = carService.findCarsRentedBetween(new Date(2000L), new Date(8000L));
        List<CarTO> cars2 = carService.findCarsRentedBetween(new Date(100L), new Date(2000L));
        List<CarTO> cars3 = carService.findCarsRentedBetween(new Date(100L), new Date(200L));
        List<CarTO> cars4 = carService.findCarsRentedBetween(new Date(2000L), new Date(12000L));
        List<CarTO> cars5 = carService.findCarsRentedBetween(new Date(11000L), new Date(12000L));

        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars2.size()).isEqualTo(1);
        assertThat(cars3.size()).isEqualTo(0);
        assertThat(cars4.size()).isEqualTo(1);
        assertThat(cars5.size()).isEqualTo(0);
    }

    @Test
    @Transactional
    public void shouldFindCarsRentedMoreThanByTenClients() {
        //given
        RentalTO rentalTO = new RentalTO().builder().cost(2000).startDate(new Date()).build();
        RentalTO addedRental = rentalService.addRental(rentalTO);
        RentalTO addedRental2 = rentalService.addRental(rentalTO);
        RentalTO addedRental3 = rentalService.addRental(rentalTO);
        RentalTO addedRental4 = rentalService.addRental(rentalTO);
        RentalTO addedRental5 = rentalService.addRental(rentalTO);
        RentalTO addedRental6 = rentalService.addRental(rentalTO);
        RentalTO addedRental7 = rentalService.addRental(rentalTO);
        RentalTO addedRental8 = rentalService.addRental(rentalTO);
        RentalTO addedRental9 = rentalService.addRental(rentalTO);
        RentalTO addedRental10 = rentalService.addRental(rentalTO);
        RentalTO addedRental11 = rentalService.addRental(rentalTO);
        RentalTO addedRental12 = rentalService.addRental(rentalTO);
        RentalTO addedRental13 = rentalService.addRental(rentalTO);
        RentalTO addedRental14 = rentalService.addRental(rentalTO);
        RentalTO addedRental15 = rentalService.addRental(rentalTO);

        CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();
        CarTO addedCar = carService.addCar(car);
        CarTO addedCar2 = carService.addCar(car);

        ClientTO clientTO = new ClientTO().builder().dateOfBirth(new Date()).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe")
                .creditCardNumber("1234567890123456").email("seba.kox@gmailcom")
                .build();

        ClientTO addedClient = clientService.addClient(clientTO);
        ClientTO addedClient2 = clientService.addClient(clientTO);
        ClientTO addedClient3 = clientService.addClient(clientTO);
        ClientTO addedClient4 = clientService.addClient(clientTO);
        ClientTO addedClient5 = clientService.addClient(clientTO);
        ClientTO addedClient6 = clientService.addClient(clientTO);
        ClientTO addedClient7 = clientService.addClient(clientTO);
        ClientTO addedClient8 = clientService.addClient(clientTO);
        ClientTO addedClient9 = clientService.addClient(clientTO);
        ClientTO addedClient10 = clientService.addClient(clientTO);
        ClientTO addedClient11 = clientService.addClient(clientTO);
        ClientTO addedClient12 = clientService.addClient(clientTO);
        ClientTO addedClient13 = clientService.addClient(clientTO);
        ClientTO addedClient14 = clientService.addClient(clientTO);
        ClientTO addedClient15 = clientService.addClient(clientTO);

        //when
        carService.createRental(addedCar, addedRental, addedClient);
        carService.createRental(addedCar, addedRental2, addedClient2);
        carService.createRental(addedCar, addedRental3, addedClient3);
        carService.createRental(addedCar, addedRental4, addedClient4);
        carService.createRental(addedCar, addedRental5, addedClient5);
        carService.createRental(addedCar, addedRental6, addedClient6);
        carService.createRental(addedCar, addedRental7, addedClient7);
        carService.createRental(addedCar, addedRental8, addedClient8);
        carService.createRental(addedCar, addedRental9, addedClient9);
        carService.createRental(addedCar, addedRental10, addedClient10);
        carService.createRental(addedCar, addedRental11, addedClient11);
        carService.createRental(addedCar2, addedRental12, addedClient12);
        carService.createRental(addedCar2, addedRental13, addedClient13);
        carService.createRental(addedCar2, addedRental14, addedClient14);
        carService.createRental(addedCar2, addedRental15, addedClient15);

        List<CarTO> cars = carService.findCarsRentedByMoreThanTenClients();

        //then
        assertThat(cars.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldFindCarByBrandCriteriaApi() {
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
        List<CarTO> cars = carService.findCarByBrandCriteriaApi(brand);

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream().anyMatch(c -> c.getBrand().equals(brand))).isTrue();
    }
}
