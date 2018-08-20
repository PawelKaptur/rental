package com.capgemini.mappers;

import com.capgemini.domain.ClientEntity;
import com.capgemini.types.ClientTO;
import com.capgemini.types.ClientTO.ClientTOBuilder;

import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientEntity toClientEntity(ClientTO clientTO){
        if(clientTO == null){
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(clientTO.getId());
        clientEntity.setCity(clientTO.getCity());
        clientEntity.setCreditCardNumber(clientTO.getCreditCardNumber());
        clientEntity.setDateOfBirth(clientTO.getDateOfBirth());
        clientEntity.setEmail(clientTO.getEmail());
        clientEntity.setFirstName(clientTO.getFirstName());
        clientEntity.setLastName(clientTO.getLastName());
        clientEntity.setPhoneNumber(clientTO.getPhoneNumber());
        clientEntity.setPostalCode(clientTO.getPostalCode());
        clientEntity.setStreet(clientTO.getStreet());

        return clientEntity;
    }

    public static ClientTO toClientTO(ClientEntity clientEntity) {
        if(clientEntity == null){
            return null;
        }

        ClientTOBuilder clientTOBuilder = new ClientTO().builder().id(clientEntity.getId())
                .firstName(clientEntity.getFirstName()).lastName(clientEntity.getLastName())
                .city(clientEntity.getCity()).dateOfBirth(clientEntity.getDateOfBirth())
                .creditCardNumber(clientEntity.getCreditCardNumber()).email(clientEntity.getEmail())
                .phoneNumber(clientEntity.getPhoneNumber()).postalCode(clientEntity.getPostalCode())
                .street(clientEntity.getStreet());

        if (clientEntity.getRentals() != null){
            clientTOBuilder = clientTOBuilder.rentals(clientEntity.getRentals().stream().map(w -> w.getId()).collect(Collectors.toList()));
        }

        return clientTOBuilder.build();
    }
}
