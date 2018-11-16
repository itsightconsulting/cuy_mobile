package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Parameter;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.ParameterRepository;
import com.itsight.cuy.service.ParameterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParameterServiceImpl extends BaseServiceImpl<ParameterRepository> implements ParameterService {

    public ParameterServiceImpl(ParameterRepository repository) {
        super(repository);
    }

    @Override
    public Parameter save(Parameter entity) {
        return repository.save(entity);
    }

    @Override
    public Parameter update(Parameter entity) {
        return null;
    }

    @Override
    public Parameter findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Parameter findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Parameter> findAll() {
        return null;
    }
}
