package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Plan;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.PlanRepository;
import com.itsight.cuy.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanServiceImpl extends BaseServiceImpl<PlanRepository> implements PlanService {

    @Autowired
    public PlanServiceImpl(PlanRepository repository) {
        super(repository);
    }

    @Override
    public Plan save(Plan entity) {
        return repository.save(entity);
    }

    @Override
    public Plan update(Plan entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Plan findOne(int id) {
        Optional<Plan> optObj = repository.findById(id);
        if(optObj.isPresent())
            return optObj.get();
        return null;
    }

    @Override
    public Plan findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(new Integer(id));
    }

    @Override
    public List<Plan> findAll() {
        return repository.findAll();
    }
}
