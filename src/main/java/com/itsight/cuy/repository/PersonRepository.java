package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Person;
import com.itsight.cuy.domain.jsonb.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person findByDocumentNumber(String number);

    List<Person> findAll();
    Person findById(int id);

    @Query("SELECT P FROM Person P where P.flagActive = ?1")
    List<Person> findAllByFlagActive(boolean status);

    @Query("SELECT P.preferences FROM Person P where P.id = ?1")
    Preferences findPlanPreferencesById(int personId);
}
