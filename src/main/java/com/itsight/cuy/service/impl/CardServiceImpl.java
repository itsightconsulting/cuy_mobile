package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Card;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.CardRepository;
import com.itsight.cuy.service.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardServiceImpl extends BaseServiceImpl<CardRepository> implements CardService {

    public CardServiceImpl(CardRepository repository) {
        super(repository);
    }

    @Override
    public Card save(Card entity) {
        return repository.save(entity);
    }

    @Override
    public Card update(Card entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Card findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Card findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(new Integer(id));
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Card> findIdPersona(int id) {
        return repository.findIdPersona(id);
    }

    @Override
    public Card findByPersonaIdByDigits(int id, String number) {
        return repository.findByPersonaIdByDigits(id, number);
    }

    public int getPersonIdById(int id) {
        return repository.getPersonIdById(id);
    }
}
