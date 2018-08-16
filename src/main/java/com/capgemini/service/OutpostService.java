package com.capgemini.service;

import com.capgemini.types.OutpostTO;
import com.capgemini.types.WorkerTO;

import java.util.List;

public interface OutpostService {
    OutpostTO findOutpostById(Long id);

    OutpostTO addOutpost(OutpostTO outpost);

    void deleteAll();

    List<OutpostTO> findAll();

    void deleteOutpost(Long id);

    OutpostTO updateOutpost(OutpostTO outpost);

    void addWorkerToOutpost(OutpostTO outpost, WorkerTO worker);
}
