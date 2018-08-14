package com.capgemini.service.impl;

import com.capgemini.dao.OutpostDao;
import com.capgemini.domain.OutpostEntity;
import com.capgemini.mappers.OutpostMapper;
import com.capgemini.service.OutpostService;
import com.capgemini.types.OutpostTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OutpostServiceImpl implements OutpostService {

    @Autowired
    private OutpostDao outpostRepository;

    @Override
    public OutpostTO findOutpostById(Long id) {
        return OutpostMapper.toOutpostTO(outpostRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = false)
    public OutpostTO addOutpost(OutpostTO outpost) {
        OutpostEntity outpostEntity = outpostRepository.save(OutpostMapper.toOutpostEntity(outpost));
        return OutpostMapper.toOutpostTO(outpostEntity);
    }
}
