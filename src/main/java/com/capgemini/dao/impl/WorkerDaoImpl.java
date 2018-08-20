package com.capgemini.dao.impl;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {

}
