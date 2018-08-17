package com.capgemini.service;

import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;
import com.capgemini.types.WorkerTO;
import org.junit.Before;
import org.junit.Ignore;
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
public class OutpostTest {

    @Autowired
    private OutpostService outpostService;

    @Autowired
    private WorkerService workerService;

    @Test
    @Transactional
    public void shouldAddOutpost(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO addedOutpost = outpostService.addOutpost(outpostTO);

        //when
        OutpostTO selectedOutpost = outpostService.findOutpostById(addedOutpost.getId());

        //then
        assertThat(selectedOutpost.getId()).isEqualTo(addedOutpost.getId());
    }

    @Test
    @Transactional
    public void shouldDeleteAllOutpostFromRepository(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        outpostService.addOutpost(outpostTO);

        //when
        outpostService.deleteAll();
        List<OutpostTO> outposts = outpostService.findAll();

        //then
        assertThat(outposts).isEmpty();
    }

    @Test
    @Transactional
    public void shouldFindThreeOutpustsInRepository(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO2 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO3 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        outpostService.addOutpost(outpostTO);
        outpostService.addOutpost(outpostTO2);
        outpostService.addOutpost(outpostTO3);

        //when
        List<OutpostTO> outposts = outpostService.findAll();

        //then
        assertThat(outposts.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void shouldDeleteOutpustById() {
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO2 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO3 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        outpostService.addOutpost(outpostTO);
        outpostService.addOutpost(outpostTO2);
        OutpostTO outpost3TO = outpostService.addOutpost(outpostTO3);

        //when
        outpostService.deleteOutpost(outpost3TO.getId());
        List<OutpostTO> outposts = outpostService.findAll();

        //then
        assertThat(outpostService.findOutpostById(outpost3TO.getId())).isNull();
        assertThat(outposts.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    public void shouldUpdateOutpust() {
        //given
        String street = "Marcelinska";
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        //when
        OutpostTO selectedOutpost = outpostService.findOutpostById(savedOutpost.getId());
        selectedOutpost.setStreet(street);
        outpostService.updateOutpost(selectedOutpost);

        //then
        assertThat(outpostService.findOutpostById(selectedOutpost.getId()).getStreet()).isEqualTo(street);
    }

    @Test
    @Transactional
    public void shouldAddWorkerToOutpost() {
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);
        WorkerTO savedWorker2 = workerService.addWorker(worker);

        //when
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker2);

        //then
        assertThat(outpostService.findOutpostById(savedOutpost.getId()).getWorkers().size()).isEqualTo(2);
    }

    @Test
    @Transactional
    public void shouldRemoveWorkerFromOutpost(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);
        WorkerTO savedWorker2 = workerService.addWorker(worker);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker2);

        //when
        outpostService.removeWorkerFromOutpost(savedOutpost, savedWorker);

        //then
        assertThat(outpostService.findOutpostById(savedOutpost.getId()).getWorkers().size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldFindFourWorkers(){
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").build();

        WorkerTO savedWorker = workerService.addWorker(worker);
        WorkerTO savedWorker2 = workerService.addWorker(worker);
        WorkerTO savedWorker3 = workerService.addWorker(worker);
        WorkerTO savedWorker4 = workerService.addWorker(worker);

        outpostService.addWorkerToOutpost(savedOutpost, savedWorker);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker2);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker3);
        outpostService.addWorkerToOutpost(savedOutpost, savedWorker4);


        //when
        List<WorkerTO> workers = outpostService.findWorkersByOutpost(savedOutpost);

        //then
        assertThat(workers.size()).isEqualTo(4);
    }
}
