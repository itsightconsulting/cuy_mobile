package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.PersonPlan;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.PersonPlanRepository;
import com.itsight.cuy.service.PersonPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonPlanServiceImpl extends BaseServiceImpl<PersonPlanRepository> implements PersonPlanService {

    public PersonPlanServiceImpl(PersonPlanRepository repository) {
        super(repository);
    }

    @Override
    public PersonPlan save(PersonPlan entity) {
        return repository.save(entity);
    }

    @Override
    public PersonPlan update(PersonPlan entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public PersonPlan findOne(int id) {
        Optional<PersonPlan> optObj = repository.findById(id);
        if(optObj.isPresent())
            return optObj.get();
        return null;
    }

    @Override
    public PersonPlan findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(new Integer(id));
    }

    @Override
    public List<PersonPlan> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PersonPlan> findByPersonId(int personId) {
        return repository.findAllByPersonId(personId);
    }

    @Override
    public PersonPlan findByPhoneNumber(String number) {
        return repository.findByPhoneNumber(number);
    }

    @Override
    public PersonPlan findOneWithFTByNumber(String number) {
        return repository.getByPhoneNumber(number);
    }
}
