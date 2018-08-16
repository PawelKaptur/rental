package com.capgemini.dao.impl;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.OutpostEntity;
import com.capgemini.domain.WorkerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {


    @Override
    public List<WorkerEntity> findWorkerByWorkplace(OutpostEntity workplaceId) {
        TypedQuery<WorkerEntity> query = entityManager.createQuery(
                "select worker from WorkerEntity worker where worker.workplaceId = :workplaceId", WorkerEntity.class);
        query.setParameter("workplaceId", workplaceId);

        return query.getResultList();
    }
}
