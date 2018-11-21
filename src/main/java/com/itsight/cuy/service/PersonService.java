package com.itsight.cuy.service;

import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.PhoneNumber;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.itsight.cuy.generic.BaseService;

import java.util.List;

public interface PersonService extends BaseService<Person> {

    Person findByDocumentNumber(String dni);

    Preferences findPlanPreferencesById(int personId);

    List<PhoneNumber> findAllPhoneNumberByDocumentNumber(int personId);

}