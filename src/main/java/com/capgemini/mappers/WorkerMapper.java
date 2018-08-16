package com.capgemini.mappers;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.types.WorkerTO;
import com.capgemini.types.WorkerTO.WorkerTOBuilder;

public class WorkerMapper {

    public static WorkerEntity toWorkerEntity(WorkerTO worker) {
        if (worker == null){
            return null;
        }

        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(worker.getId());
        workerEntity.setCity(worker.getCity());
        workerEntity.setDateOfBirth(worker.getDateOfBirth());
        workerEntity.setFirstName(worker.getFirstName());
        workerEntity.setLastName(worker.getLastName());
        workerEntity.setOccupation(worker.getOccupation());
        workerEntity.setPhoneNumber(worker.getPhoneNumber());
        workerEntity.setPostalCode(worker.getPostalCode());
        workerEntity.setStreet(worker.getStreet());
        workerEntity.setWorkplaceId(worker.getWorkplaceId());

        return workerEntity;
    }

    public static WorkerTO toWorkerTO(WorkerEntity workerEntity) {
        if(workerEntity == null){
            return null;
        }

        return new WorkerTOBuilder().withId(workerEntity.getId()).withCity(workerEntity.getCity())
                .withFirstName(workerEntity.getFirstName()).withLastName(workerEntity.getLastName())
                .withPhoneNumber(workerEntity.getPhoneNumber()).withPostalCode(workerEntity.getPostalCode())
                .withStreet(workerEntity.getStreet()).withOccupation(workerEntity.getOccupation())
                .withDateOfBirth(workerEntity.getDateOfBirth()).withWorkplaceId(workerEntity.getWorkplaceId())
                .build();
    }
}
