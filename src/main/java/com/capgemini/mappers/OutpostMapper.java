package com.capgemini.mappers;

import com.capgemini.domain.OutpostEntity;
import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class OutpostMapper {
    public static OutpostEntity toOutpostEntity(OutpostTO outpost) {
        if (outpost == null) {
            return null;
        }

        OutpostEntity outpostEntity = new OutpostEntity();
        outpostEntity.setId(outpost.getId());
        outpostEntity.setCity(outpost.getCity());
        outpostEntity.setEmail(outpost.getEmail());
        outpostEntity.setPhoneNumber(outpost.getPhoneNumber());
        outpostEntity.setPostalCode(outpost.getPostalCode());
        outpostEntity.setStreet(outpost.getStreet());

        return outpostEntity;
    }

    public static OutpostTO toOutpostTO(OutpostEntity outpostEntity) {
        if (outpostEntity == null) {
            return null;
        }

        OutpostTOBuilder outpostTOBuilder = new OutpostTOBuilder().withId(outpostEntity.getId()).withCity(outpostEntity.getCity())
                .withPostalCode(outpostEntity.getPostalCode()).withStreet(outpostEntity.getStreet())
                .withEmail(outpostEntity.getEmail()).withPhoneNumber(outpostEntity.getPhoneNumber());

        if (outpostEntity.getWorkers() != null) {
            outpostTOBuilder = outpostTOBuilder.withWorkers(outpostEntity.getWorkers().stream().map(w -> w.getId()).collect(Collectors.toList()));
        }

        return outpostTOBuilder.build();
    }

    public static List<OutpostTO> toOutpostTOList(List<OutpostEntity> outposts) {
        return outposts.stream().map(OutpostMapper::toOutpostTO).collect(Collectors.toList());
    }
}
