package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Recharge;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.RechargeRepository;
import com.itsight.cuy.service.RechargeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RechargeServiceImpl extends BaseServiceImpl<RechargeRepository> implements RechargeService {

    public RechargeServiceImpl(RechargeRepository repository){
        super(repository);
    }

    @Override
    public Recharge save(Recharge entity) {
        return repository.save(entity);
    }

    @Override
    public Recharge update(Recharge entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Recharge findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Recharge findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(new Integer(id));
    }

    @Override
    public List<Recharge> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Recharge> findAllByNumber(String phoneNumber) {
        return repository.findAllByNumber(phoneNumber);
    }
}
