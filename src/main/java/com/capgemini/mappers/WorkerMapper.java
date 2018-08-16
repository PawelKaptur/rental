package com.capgemini.mappers;

        import com.capgemini.domain.WorkerEntity;
        import com.capgemini.service.OutpostService;
        import com.capgemini.types.WorkerTO;
        import com.capgemini.types.WorkerTO.WorkerTOBuilder;
        import org.springframework.beans.factory.annotation.Autowired;

        import java.util.List;
        import java.util.stream.Collectors;

public class WorkerMapper {

/*    @Autowired
    private static OutpostService outpostService;*/

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
        //workerEntity.setWorkplaceId(worker.getWorkplaceId());
        //workerEntity.setWorkplaceId(OutpostMapper.toOutpostEntity(outpostService.findOutpostById(worker.getWorkplaceId())));
        //workerEntity.setWorkplaceId(OutpostMapper.toOutpostEntity(worker.getWorkplaceId()));

        return workerEntity;
    }

    public static WorkerTO toWorkerTO(WorkerEntity workerEntity) {
        if(workerEntity == null){
            return null;
        }

        //withWorkplaceId(workerEntity.getWorkplaceId())
        //withWorkplaceId(workerEntity.getWorkplaceId().getId())
/*        return new WorkerTOBuilder().withId(workerEntity.getId()).withCity(workerEntity.getCity())
                .withFirstName(workerEntity.getFirstName()).withLastName(workerEntity.getLastName())
                .withPhoneNumber(workerEntity.getPhoneNumber()).withPostalCode(workerEntity.getPostalCode())
                .withStreet(workerEntity.getStreet()).withOccupation(workerEntity.getOccupation())
                .withDateOfBirth(workerEntity.getDateOfBirth()).withWorkplaceId(OutpostMapper.toOutpostTO(workerEntity.getWorkplaceId()))
                .build();*/


        // .workplaceId(OutpostMapper.toOutpostTO(workerEntity.getWorkplaceId()))
        return new WorkerTO().builder().id(workerEntity.getId()).city(workerEntity.getCity())
                .firstName(workerEntity.getFirstName()).lastName(workerEntity.getLastName())
                .phoneNumber(workerEntity.getPhoneNumber()).postalCode(workerEntity.getPostalCode())
                .street(workerEntity.getStreet()).occupation(workerEntity.getOccupation())
                .dateOfBirth(workerEntity.getDateOfBirth())
                .build();
    }

    public static List<WorkerTO> toWorkerTOList(List<WorkerEntity> workers) {
        return workers.stream().map(WorkerMapper::toWorkerTO).collect(Collectors.toList());
    }

    public static List<WorkerEntity> toWorkerEntityList(List<WorkerTO> workers) {
        return workers.stream().map(WorkerMapper::toWorkerEntity).collect(Collectors.toList());
    }
}
