/*
package com.capgemini.service;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.WorkerTO;
import com.capgemini.types.WorkerTO.WorkerTOBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerTest {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private OutpostService outpostService;

    @Before
    public void setUp(){
        workerService.deleteAll();
    }


    @Test
    public void shouldFindWorkerById(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

       */
/* WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).withOccupation("manager").withStreet("asd").withPostalCode(12345)
                .withPhoneNumber(987654321L).withFirstName("Seba").withLastName("Kox").withCity("qwe").withWorkplaceId(savedOutpost).build();*//*


        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();
        //.workplaceId(savedOutpost)
        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        WorkerTO selectedWorker = workerService.findWorkerById(savedWorker.getId());

        //then
        assertThat(selectedWorker.getId()).isEqualTo(savedWorker.getId());
    }

*/
/*    @Test
    public void shouldDeleteWorkerFromOutpost(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost).build();

        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        workerService.deleteWorkerFromOutpost(savedWorker);
        WorkerTO selectedWorker = workerService.findWorkerById(savedWorker.getId());

        //then
        assertThat(selectedWorker.getWorkplaceId()).isNull();
    }*//*


    @Test
    public void shouldFindAllWorkers(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost).build();
        //.workplaceId(savedOutpost)
        workerService.addWorker(worker);
        workerService.addWorker(worker);
        workerService.addWorker(worker);

        //when
        List<WorkerTO> workers = workerService.findAllWorkers();

        //then
        assertThat(workers.size()).isEqualTo(3);
    }

    @Test
    public void shouldDeleteAllWorkers(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost).build();

        workerService.addWorker(worker);
        workerService.addWorker(worker);
        workerService.addWorker(worker);

        //when
        workerService.deleteAll();

        //then
        assertThat(workerService.findAllWorkers()).isEmpty();
    }

    @Test
    public void shouldFindWorkersByOutpost(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);
        OutpostTO savedOutpost2 = outpostService.addOutpost(outpostTO);

        Long id = savedOutpost.getId();

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost).build();
        WorkerTO worker2 = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost2).build();

        workerService.addWorker(worker);
        workerService.addWorker(worker);
        workerService.addWorker(worker);

        workerService.addWorker(worker2);
        workerService.addWorker(worker2);

        //when
        List<WorkerTO> workers = workerService.findWorkersByOutpost(savedOutpost);
        List<WorkerTO> workers2 = workerService.findWorkersByOutpost(savedOutpost2);

        //then

        assertThat(workers.size()).isEqualTo(3);
        assertThat(workers2.size()).isEqualTo(2);
    }
}
*/
