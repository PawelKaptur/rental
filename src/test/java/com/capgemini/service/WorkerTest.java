package com.capgemini.service;

import com.capgemini.domain.WorkerEntity;
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

    @Test
    public void shouldFindWorkerById(){
        //given
        WorkerTO worker = new WorkerTOBuilder().withDateOfBirth(new Date()).withOccupation("manager").withStreet("asd").withPostalCode(12345)
                .withPhoneNumber(987654321L).withFirstName("Seba").withLastName("Kox").withCity("qwe").withWorkplaceId(1L).build();

        WorkerTO savedWorker = workerService.addWorker(worker);

        //when
        WorkerTO selectedWorker = workerService.findWorkerById(savedWorker.getId());

        //then
        assertThat(selectedWorker.getId()).isEqualTo(savedWorker.getId());
    }
}
