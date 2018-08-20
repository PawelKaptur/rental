package com.capgemini.dao.impl;

import com.capgemini.WorkerSearchCriteria;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {
    @Override
    public List<WorkerEntity> findWorkersByParams(WorkerSearchCriteria workerSearchCriteria) {
        Long car = 0L;
        Long outpost = 0L;
        String occupation = "";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select worker from WorkerEntity worker");


        if (workerSearchCriteria.getCarEntity() != null) {
            car = workerSearchCriteria.getCarEntity();
            stringBuilder.append(" join worker.cars c where c.id =:carId");
        }

        if (workerSearchCriteria.getOutpostEntity() != null) {
            outpost = workerSearchCriteria.getOutpostEntity();
            if (workerSearchCriteria.getCarEntity() != null) {
                stringBuilder.append(" and");
            } else {
                stringBuilder.append(" where");
            }
            stringBuilder.append(" worker.workplaceId.id=:workplaceId");
        }

        if (workerSearchCriteria.getOccupation() != null) {
            occupation = workerSearchCriteria.getOccupation();
            if (workerSearchCriteria.getCarEntity() != null || workerSearchCriteria.getOutpostEntity() != null) {
                stringBuilder.append(" and");
            } else {
                stringBuilder.append(" where");
            }

            stringBuilder.append(" worker.occupation=:occupation");
        }

        TypedQuery<WorkerEntity> query = entityManager.createQuery(stringBuilder.toString(), WorkerEntity.class);

        if (workerSearchCriteria.getCarEntity() != null) {
            query.setParameter("carId", car);
        }
        if (workerSearchCriteria.getOccupation() != null) {
            query.setParameter("occupation", occupation);
        }
        if (workerSearchCriteria.getOutpostEntity() != null) {
            query.setParameter("workplaceId", outpost);
        }

        return query.getResultList();
    }
}
