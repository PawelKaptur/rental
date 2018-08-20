package com.capgemini.service;

import com.capgemini.WorkerSearchCriteria;
import com.capgemini.types.CarTO;
import com.capgemini.types.OutpostTO;
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
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class WorkerTest {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private OutpostService outpostService;

    @Autowired
    private CarService carService;

    @Test
    @Transactional
    public void shouldFindWorkerById() {
        //given
        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        WorkerTO selectedWorker = workerService.findWorkerById(savedWorker.getId());

        //then
        assertThat(selectedWorker.getId()).isEqualTo(savedWorker.getId());
    }

    @Test
    @Transactional
    public void shouldFindAllWorkers() {
        //given
        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        workerService.addWorker(worker);
        workerService.addWorker(worker);
        workerService.addWorker(worker);

        //when
        List<WorkerTO> workers = workerService.findAllWorkers();

        //then
        assertThat(workers.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void shouldDeleteAllWorkers() {
        //given
        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        workerService.addWorker(worker);
        workerService.addWorker(worker);
        workerService.addWorker(worker);

        //when
        workerService.deleteAll();

        //then
        assertThat(workerService.findAllWorkers()).isEmpty();
    }

    @Test
    @Transactional
    public void shouldReturnWorkersByFindingThemByDifferentParams() {
        //given
        String manager = "manager";
        String clerk = "clerk";
        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation(manager).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();
        WorkerTO worker2 = new WorkerTO().builder().dateOfBirth(new Date()).occupation(clerk).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);
        WorkerTO savedWorker2 = workerService.addWorker(worker2);
        WorkerTO savedWorker3 = workerService.addWorker(worker2);

        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        outpostService.addWorkerToOutpost(savedOutpost, savedWorker);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker2);

        CarTO car = new CarTO.CarTOBuilder().withBrand("Audi").withType("sedan")
                .withModel("A4").withPower(200).withEngineCapacity(1.8).withCourse(5000).withColor("Black")
                .withProductionYear(2015).build();

        CarTO savedCar = carService.addCar(car);
        carService.addWardenToCar(savedCar, savedWorker);

        //when
        WorkerSearchCriteria workerSearchCriteria = new WorkerSearchCriteria();
        workerSearchCriteria.setOccupation(manager);
        workerSearchCriteria.setOutpostEntity(savedOutpost.getId());
        workerSearchCriteria.setCarEntity(savedCar.getId());

        WorkerSearchCriteria workerSearchCriteria2 = new WorkerSearchCriteria();
        workerSearchCriteria2.setOccupation(clerk);

        WorkerSearchCriteria workerSearchCriteria3 = new WorkerSearchCriteria();
        workerSearchCriteria3.setCarEntity(savedCar.getId());

        WorkerSearchCriteria workerSearchCriteria4 = new WorkerSearchCriteria();
        workerSearchCriteria4.setOutpostEntity(savedOutpost.getId());

        WorkerSearchCriteria workerSearchCriteria5 = new WorkerSearchCriteria();
        workerSearchCriteria5.setOccupation(manager);
        workerSearchCriteria5.setOutpostEntity(savedOutpost.getId());

        WorkerSearchCriteria workerSearchCriteria6 = new WorkerSearchCriteria();
        workerSearchCriteria6.setOccupation(manager);
        workerSearchCriteria6.setCarEntity(savedCar.getId());

        WorkerSearchCriteria workerSearchCriteria7 = new WorkerSearchCriteria();
        workerSearchCriteria7.setCarEntity(savedCar.getId());
        workerSearchCriteria7.setOutpostEntity(savedOutpost.getId());

        List<WorkerTO> workers = workerService.findWorkerByParams(workerSearchCriteria);
        List<WorkerTO> workers2 = workerService.findWorkerByParams(workerSearchCriteria2);
        List<WorkerTO> workers3 = workerService.findWorkerByParams(workerSearchCriteria3);
        List<WorkerTO> workers4 = workerService.findWorkerByParams(workerSearchCriteria4);
        List<WorkerTO> workers5 = workerService.findWorkerByParams(workerSearchCriteria5);
        List<WorkerTO> workers6 = workerService.findWorkerByParams(workerSearchCriteria6);
        List<WorkerTO> workers7 = workerService.findWorkerByParams(workerSearchCriteria7);

        //then
        assertThat(workers.size()).isEqualTo(1);
        assertThat(workers2.size()).isEqualTo(2);
        assertThat(workers3.size()).isEqualTo(1);
        assertThat(workers4.size()).isEqualTo(2);
        assertThat(workers5.size()).isEqualTo(1);
        assertThat(workers6.size()).isEqualTo(1);
        assertThat(workers7.size()).isEqualTo(1);
    }
}
