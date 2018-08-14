package com.capgemini.service;

import com.capgemini.types.OutpostTO;

public interface OutpostService {
    OutpostTO findOutpostById(Long id);

    OutpostTO addOutpost(OutpostTO outpost);
}
