package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.PersonRepository;
import com.itsight.cuy.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<PersonRepository> implements PersonService {

    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public Person save(Person entity) {
        return repository.save(entity);
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public Person findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Person findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Person> findAll() {
        return repository.findAllByFlagActive(true);
    }

    @Override
    public Person findByDocumentNumber(String dni) {
        return repository.findByDocumentNumber(dni);
    }

    @Override
    public Preferences findPlanPreferencesById(int personId) {
        return repository.findPlanPreferencesById(personId);
    }
}
