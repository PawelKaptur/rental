package com.capgemini.service;

import com.capgemini.types.WorkerTO;

import java.util.List;

public interface WorkerService {
    WorkerTO findWorkerById(Long id);

    WorkerTO addWorker(WorkerTO worker);

    void deleteAll();

    List<WorkerTO> findAllWorkers();
}
