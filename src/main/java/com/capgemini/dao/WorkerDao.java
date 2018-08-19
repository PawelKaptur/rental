package com.capgemini.dao;

import com.capgemini.domain.OutpostEntity;
import com.capgemini.domain.WorkerEntity;

import java.util.List;

public interface WorkerDao extends Dao<WorkerEntity, Long> {
    List<WorkerEntity> findWorkerByWorkplace(OutpostEntity outpostEntity);
}
