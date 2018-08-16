package com.capgemini.service;

import com.capgemini.types.WorkerTO;

public interface WorkerService {
    WorkerTO findWorkerById(Long id);

    WorkerTO addWorker(WorkerTO worker);
}
