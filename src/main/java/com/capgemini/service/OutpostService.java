package com.capgemini.service;

import com.capgemini.types.OutpostTO;

import java.util.List;

public interface OutpostService {
    OutpostTO findOutpostById(Long id);

    OutpostTO addOutpost(OutpostTO outpost);

    void deleteAll();

    List<OutpostTO> findAll();

    void deleteOutpost(Long id);
}
