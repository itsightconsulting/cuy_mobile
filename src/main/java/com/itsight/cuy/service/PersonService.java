package com.itsight.cuy.service;

import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.itsight.cuy.generic.BaseService;

public interface PersonService extends BaseService<Person> {

    Person findByDocumentNumber(String dni);

    Preferences findPlanPreferencesById(int personId);
}