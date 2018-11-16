package com.itsight.cuy.repository;

import com.itsight.cuy.domain.PersonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonPlanRepository extends JpaRepository<PersonPlan, Integer> {

    @Query("SELECT PP FROM PersonPlan PP WHERE PP.person.id = ?1")
    List<PersonPlan> findAllByPersonId(int personId);
}
