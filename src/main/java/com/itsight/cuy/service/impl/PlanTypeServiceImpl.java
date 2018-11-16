package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.PlanType;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.PlanTypeRepository;
import com.itsight.cuy.service.PlanTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanTypeServiceImpl extends BaseServiceImpl<PlanTypeRepository> implements PlanTypeService {

    public PlanTypeServiceImpl(PlanTypeRepository repository) {
        super(repository);
    }

    @Override
    public PlanType save(PlanType entity) {
        return repository.save(entity);
    }

    @Override
    public PlanType update(PlanType entity) {
        return null;
    }

    @Override
    public PlanType findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public PlanType findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<PlanType> findAll() {
        return repository.findAllbyFlagActivo(true);
    }
}
