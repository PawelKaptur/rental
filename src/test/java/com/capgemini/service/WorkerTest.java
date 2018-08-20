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

import javax.transaction.Transactional;
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

    @Test
    @Transactional
    public void shouldFindWorkerById(){
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
    public void shouldFindAllWorkers(){
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
    public void shouldDeleteAllWorkers(){
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
}
