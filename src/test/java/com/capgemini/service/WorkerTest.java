package com.capgemini.service;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.WorkerTO;
import com.capgemini.types.WorkerTO.WorkerTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerTest {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private OutpostService outpostService;

    @Test
    public void shouldFindWorkerById(){
        //given
        OutpostTO outpostTO = new OutpostTO.OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO savedOutpost = outpostService.addOutpost(outpostTO);

       /* WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).withOccupation("manager").withStreet("asd").withPostalCode(12345)
                .withPhoneNumber(987654321L).withFirstName("Seba").withLastName("Kox").withCity("qwe").withWorkplaceId(savedOutpost).build();*/

        WorkerTO worker = new WorkerTO().builder().dateOfBirth(new Date()).occupation("manager").street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe").workplaceId(savedOutpost).build();

        System.out.println(worker);
        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        WorkerTO selectedWorker = workerService.findWorkerById(savedWorker.getId());

        //then
        assertThat(selectedWorker.getId()).isEqualTo(savedWorker.getId());
    }
}
