package com.capgemini.service.impl;


import com.capgemini.dao.ClientDao;
import com.capgemini.domain.ClientEntity;
import com.capgemini.mappers.ClientMapper;
import com.capgemini.service.ClientService;
import com.capgemini.types.ClientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {

    private ClientDao clientRepository;

    @Autowired
    public ClientServiceImpl(ClientDao clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientTO findClientById(Long id) {
        return ClientMapper.toClientTO(clientRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public ClientTO addClient(ClientTO client) {
        ClientEntity clientEntity = clientRepository.save(ClientMapper.toClientEntity(client));
        return ClientMapper.toClientTO(clientEntity);
    }
}
