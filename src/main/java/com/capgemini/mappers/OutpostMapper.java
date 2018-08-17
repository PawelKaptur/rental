package com.capgemini.mappers;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.OutpostEntity;
import com.capgemini.service.WorkerService;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;
import com.capgemini.types.WorkerTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutpostMapper {
/*    @Autowired
    private static WorkerService workerService;*/


    @Autowired
    private static WorkerDao workerDao;

    public static OutpostEntity toOutpostEntity(OutpostTO outpost) {
        if (outpost == null){
            return null;
        }

        OutpostEntity outpostEntity = new OutpostEntity();
        outpostEntity.setId(outpost.getId());
        outpostEntity.setCity(outpost.getCity());
        outpostEntity.setEmail(outpost.getEmail());
        outpostEntity.setPhoneNumber(outpost.getPhoneNumber());
        outpostEntity.setPostalCode(outpost.getPostalCode());
        outpostEntity.setStreet(outpost.getStreet());

/*        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkerService");
        EntityManager em = emf.createEntityManager();
        WorkerEntity workerEntity = em.find(WorkerEntity.class, 1);
        System.out.println(workerEntity);*/

/*        if(outpost.getWorkers() != null){
            outpostEntity.setWorkers(WorkerMapper.toWorkerEntityList(outpost.getWorkers()));
        }    */

//nizej nie dziala, to wyzej tak srednio

        if(outpost.getWorkers() != null){

            List<Long> workersId = outpost.getWorkers();
            List<WorkerTO> workersTO = new ArrayList<>();

            //worker service null, jak to ogarnac??
            for(Long id: workersId){
                //workersTO.add(workerService.findWorkerById(id));
                workersTO.add(WorkerMapper.toWorkerTO((workerDao.findOne(id))));
            }

            outpostEntity.setWorkers(WorkerMapper.toWorkerEntityList(workersTO));
        }

        return outpostEntity;
    }

    public static OutpostTO toOutpostTO(OutpostEntity outpostEntity) {
        if(outpostEntity == null){
            return null;
        }

        if(outpostEntity.getWorkers() != null) {
         /*   return new OutpostTOBuilder().withId(outpostEntity.getId()).withCity(outpostEntity.getCity())
                    .withPostalCode(outpostEntity.getPostalCode()).withStreet(outpostEntity.getStreet())
                    .withEmail(outpostEntity.getEmail()).withPhoneNumber(outpostEntity.getPhoneNumber())
                    .withWorkers(WorkerMapper.toWorkerTOList(outpostEntity.getWorkers()))
                    .build();*/

            return new OutpostTOBuilder().withId(outpostEntity.getId()).withCity(outpostEntity.getCity())
                    .withPostalCode(outpostEntity.getPostalCode()).withStreet(outpostEntity.getStreet())
                    .withEmail(outpostEntity.getEmail()).withPhoneNumber(outpostEntity.getPhoneNumber())
                    .withWorkers(outpostEntity.getWorkers().stream().map(w -> w.getId()).collect(Collectors.toList()))
                    .build();
        }

        return new OutpostTOBuilder().withId(outpostEntity.getId()).withCity(outpostEntity.getCity())
                .withPostalCode(outpostEntity.getPostalCode()).withStreet(outpostEntity.getStreet())
                .withEmail(outpostEntity.getEmail()).withPhoneNumber(outpostEntity.getPhoneNumber())
                .build();

    }

    public static List<OutpostTO> toOutpostTOList(List<OutpostEntity> outposts) {
        return outposts.stream().map(OutpostMapper::toOutpostTO).collect(Collectors.toList());
    }
}
