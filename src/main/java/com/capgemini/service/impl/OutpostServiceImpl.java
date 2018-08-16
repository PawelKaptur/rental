package com.capgemini.service.impl;

import com.capgemini.dao.OutpostDao;
import com.capgemini.domain.OutpostEntity;
import com.capgemini.mappers.OutpostMapper;
import com.capgemini.service.OutpostService;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OutpostServiceImpl implements OutpostService {

    @Autowired
    private OutpostDao outpostRepository;

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

    @Override
    @Transactional(readOnly = false)
    public OutpostTO updateOutpost(OutpostTO outpost) {
        OutpostEntity outpostEntity = outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));
        return OutpostMapper.toOutpostTO(outpostEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void addWorkerToOutpost(OutpostTO outpost, WorkerTO worker) {
        List<WorkerTO> workers;

        if(outpost.getWorkers() != null){
             workers = outpost.getWorkers();
        }
        else {
            workers = new LinkedList<>();
        }

        workers.add(worker);
        outpost.setWorkers(workers);
        OutpostEntity outpostEntity = outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));
    }

    @Override
    @Transactional(readOnly = false)
    public void removeWorkerFromOutpost(OutpostTO outpost, WorkerTO worker) {
        List<WorkerTO> workers;

        if(outpost.getWorkers() != null){
            workers = outpost.getWorkers();
        }
        else {
            workers = new LinkedList<>();
        }

        workers.remove(worker);
        outpost.setWorkers(workers);
        OutpostEntity outpostEntity = outpostRepository.update(OutpostMapper.toOutpostEntity(outpost));
    }


}
