package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Operator;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.OperatorRepository;
import com.itsight.cuy.service.OperatorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperatorServiceImpl extends BaseServiceImpl<OperatorRepository> implements OperatorService {

    public OperatorServiceImpl(OperatorRepository repository) {
        super(repository);
    }

    @Override
    public Operator save(Operator entity) {
        return repository.save(entity);
    }

    @Override
    public Operator update(Operator entity) {
        return null;
    }

    @Override
    public Operator findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Operator findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Operator> findAll() {
        return repository.findAllbyFlagActivo(true);
    }
}
