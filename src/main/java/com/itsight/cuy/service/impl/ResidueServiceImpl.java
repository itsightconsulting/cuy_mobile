package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Residue;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.ResidueRepository;
import com.itsight.cuy.service.ResidueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResidueServiceImpl extends BaseServiceImpl<ResidueRepository> implements ResidueService {

    public ResidueServiceImpl(ResidueRepository repository) {
        super(repository);
    }

    @Override
    public Residue save(Residue entity) {
        return repository.save(entity);
    }

    @Override
    public Residue update(Residue entity) {
        return null;
    }

    @Override
    public Residue findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Residue findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Residue> findAll() {
        return null;
    }
}
