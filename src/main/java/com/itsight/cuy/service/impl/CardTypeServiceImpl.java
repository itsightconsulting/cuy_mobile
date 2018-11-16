package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.CardType;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.CardTypeRepository;
import com.itsight.cuy.service.CardTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardTypeServiceImpl extends BaseServiceImpl<CardTypeRepository> implements CardTypeService {

    public CardTypeServiceImpl(CardTypeRepository repository) {
        super(repository);
    }

    @Override
    public CardType save(CardType entity) {
        return repository.save(entity);
    }

    @Override
    public CardType update(CardType entity) {
        return null;
    }

    @Override
    public CardType findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public CardType findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(new Integer(id));
    }

    @Override
    public List<CardType> findAll() {
        return repository.findAllbyFlagActivo(true);
    }
}
