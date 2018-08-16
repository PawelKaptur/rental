package com.capgemini.dao;

import com.capgemini.domain.OutpostEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.types.OutpostTO;

import java.util.List;

public interface WorkerDao extends Dao<WorkerEntity, Long> {

    //List<WorkerEntity> findWorkerByWorkplace(Long id);
    List<WorkerEntity> findWorkerByWorkplace(OutpostEntity outpostEntity);
}
