package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.PersonType;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.PersonTypeRepository;
import com.itsight.cuy.service.PersonTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonTypeServiceImpl extends BaseServiceImpl<PersonTypeRepository> implements PersonTypeService {

    public PersonTypeServiceImpl(PersonTypeRepository repository) {
        super(repository);
    }

    @Override
    public PersonType save(PersonType entity) {
        return repository.save(entity);
    }

    @Override
    public PersonType update(PersonType entity) {
        return null;
    }

    @Override
    public PersonType findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public PersonType findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<PersonType> findAll() {
        return repository.findAllbyFlagActivo(true);
    }
}
