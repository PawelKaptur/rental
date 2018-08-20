package com.capgemini.mappers;

import com.capgemini.domain.WorkerEntity;
import com.capgemini.types.WorkerTO;
import com.capgemini.types.WorkerTO.WorkerTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerMapper {

    public static WorkerEntity toWorkerEntity(WorkerTO worker) {
        if (worker == null) {
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

        return workerEntity;
    }

    public static WorkerTO toWorkerTO(WorkerEntity workerEntity) {
        if (workerEntity == null) {
            return null;
        }

        WorkerTOBuilder workerTOBuilder = new WorkerTO().builder().id(workerEntity.getId()).city(workerEntity.getCity())
                .firstName(workerEntity.getFirstName()).lastName(workerEntity.getLastName())
                .phoneNumber(workerEntity.getPhoneNumber()).postalCode(workerEntity.getPostalCode())
                .street(workerEntity.getStreet()).occupation(workerEntity.getOccupation())
                .dateOfBirth(workerEntity.getDateOfBirth());

        if (workerEntity.getWorkplaceId() != null) {
            workerTOBuilder = workerTOBuilder.workplaceId(workerEntity.getWorkplaceId().getId());
        }

        if (workerEntity.getCars() != null) {
            workerTOBuilder = workerTOBuilder.cars(workerEntity.getCars().stream().map(c -> c.getId()).collect(Collectors.toList()));
        }

        return workerTOBuilder.build();
    }

    public static List<WorkerTO> toWorkerTOList(List<WorkerEntity> workers) {
        return workers.stream().map(WorkerMapper::toWorkerTO).collect(Collectors.toList());
    }

    public static List<WorkerEntity> toWorkerEntityList(List<WorkerTO> workers) {
        return workers.stream().map(WorkerMapper::toWorkerEntity).collect(Collectors.toList());
    }
}
