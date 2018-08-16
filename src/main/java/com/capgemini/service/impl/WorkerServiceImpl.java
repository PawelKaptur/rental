package com.capgemini.service.impl;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.mappers.WorkerMapper;
import com.capgemini.service.WorkerService;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerRepository;

    @Override
    public WorkerTO findWorkerById(Long id) {
        return WorkerMapper.toWorkerTO(workerRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public WorkerTO addWorker(WorkerTO worker) {
        WorkerEntity workerEntity = workerRepository.save(WorkerMapper.toWorkerEntity(worker));
        return WorkerMapper.toWorkerTO(workerEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteWorkerFromOutpost(WorkerTO worker) {
        WorkerTO workerTO = findWorkerById(worker.getId());
        workerTO.setWorkplaceId(null);
        updateWorker(workerTO);
    }

    @Override
    public WorkerTO updateWorker(WorkerTO worker) {
        WorkerEntity workerEntity = workerRepository.update(WorkerMapper.toWorkerEntity(worker));
        return WorkerMapper.toWorkerTO(workerEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAll() {
        workerRepository.deleteAll();
    }

    @Override
    public List<WorkerTO> findAllWorkers() {
        return WorkerMapper.toWorkerTOList(workerRepository.findAll());
    }
}
