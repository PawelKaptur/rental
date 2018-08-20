package com.capgemini.dao;

import com.capgemini.WorkerSearchCriteria;
import com.capgemini.domain.WorkerEntity;

import java.util.List;

public interface WorkerDao extends Dao<WorkerEntity, Long> {
    List<WorkerEntity> findWorkersByParams(WorkerSearchCriteria workerSearchCriteria);
}
