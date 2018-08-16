package com.capgemini.mappers;

import com.capgemini.domain.OutpostEntity;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class OutpostMapper {
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
        if(outpost.getWorkers() != null){
            outpostEntity.setWorkers(WorkerMapper.toWorkerEntityList(outpost.getWorkers()));
        }

        return outpostEntity;
    }

    public static OutpostTO toOutpostTO(OutpostEntity outpostEntity) {
        if(outpostEntity == null){
            return null;
        }

        if(outpostEntity.getWorkers() != null) {
            return new OutpostTOBuilder().withId(outpostEntity.getId()).withCity(outpostEntity.getCity())
                    .withPostalCode(outpostEntity.getPostalCode()).withStreet(outpostEntity.getStreet())
                    .withEmail(outpostEntity.getEmail()).withPhoneNumber(outpostEntity.getPhoneNumber())
                    .withWorkers(WorkerMapper.toWorkerTOList(outpostEntity.getWorkers()))
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
