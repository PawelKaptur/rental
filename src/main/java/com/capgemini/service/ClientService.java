package com.capgemini.service;

import com.capgemini.types.ClientTO;

public interface ClientService {
    ClientTO findClientById(Long id);

    ClientTO addClient(ClientTO client);
}
