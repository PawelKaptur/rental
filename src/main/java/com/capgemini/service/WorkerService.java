package com.capgemini.service;

import com.capgemini.types.WorkerTO;

import java.util.List;

public interface WorkerService {
    WorkerTO findWorkerById(Long id);

    WorkerTO addWorker(WorkerTO worker);

    void deleteWorkerFromOutpost(WorkerTO worker);

    WorkerTO updateWorker(WorkerTO worker);

    void deleteAll();

    List<WorkerTO> findAllWorkers();
}
