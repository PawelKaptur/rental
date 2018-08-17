package com.capgemini.service.impl;

import com.capgemini.dao.OutpostDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.OutpostEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.mappers.OutpostMapper;
import com.capgemini.mappers.WorkerMapper;
import com.capgemini.service.OutpostService;
import com.capgemini.service.WorkerService;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class OutpostServiceImpl implements OutpostService {

    private OutpostDao outpostRepository;
    private WorkerService workerService;
    private WorkerDao workerRepository;

    @Autowired
    public OutpostServiceImpl(OutpostDao outpostRepository, WorkerService workerService, WorkerDao workerRepository) {
        this.outpostRepository = outpostRepository;
        this.workerService = workerService;
        this.workerRepository = workerRepository;
    }

    @Override
    public OutpostTO findOutpostById(Long id) {
        return OutpostMapper.toOutpostTO(outpostRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public OutpostTO addOutpost(OutpostTO outpost) {
        OutpostEntity outpostEntity = outpostRepository.save(OutpostMapper.toOutpostEntity(outpost));
        return OutpostMapper.toOutpostTO(outpostEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAll() {
        outpostRepository.deleteAll();
    }

    @Override
    public List<OutpostTO> findAll() {
        return OutpostMapper.toOutpostTOList(outpostRepository.findAll());
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteOutpost(Long id) {
        outpostRepository.delete(id);
    }


    //bede musial zmienic na bank
    @Override
    @Transactional(readOnly = false)
    public OutpostTO updateOutpost(OutpostTO outpost) {
        OutpostEntity outpostEntity = outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));
        return OutpostMapper.toOutpostTO(outpostEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void addWorkerToOutpost(OutpostTO outpost, WorkerTO worker) {
        List<WorkerTO> workers = findWorkersByOutpost(outpost);
        List<WorkerEntity> workersEntities = new ArrayList<>();


        for(WorkerTO w: workers){
            workersEntities.add(workerRepository.findOne(w.getId()));
        }

        OutpostEntity outpostEntity = outpostRepository.findOne(outpost.getId());
        WorkerEntity addedWorker = workerRepository.findOne(worker.getId());

        addedWorker.setWorkplaceId(outpostEntity);
        workerRepository.update(addedWorker);

        workersEntities.add(addedWorker);
        outpostEntity.setWorkers(workersEntities);
        outpostRepository.update(outpostEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeWorkerFromOutpost(OutpostTO outpost, WorkerTO worker) {
        List<WorkerTO> workers = findWorkersByOutpost(outpost);

        workers.remove(worker);
        //outpost.setWorkers(workers);
        outpost.setWorkers(workers.stream().map(w -> w.getId()).collect(Collectors.toList()));
        outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));
    }

    @Override
    public List<WorkerTO> findWorkersByOutpost(OutpostTO outpost) {
        List<WorkerEntity> workers;
        OutpostEntity outpostEntity = outpostRepository.findOne(outpost.getId());

        if(outpostEntity.getWorkers() != null){
            workers = outpostEntity.getWorkers();
        }

        else {
            workers = new LinkedList<>();
        }

        List<WorkerTO> workersTO = new ArrayList<>();

        for(WorkerEntity workerEntity: workers){
            workersTO.add(WorkerMapper.toWorkerTO(workerEntity));
        }

        return workersTO;
    }
}
