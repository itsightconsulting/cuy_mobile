package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findAll();

    Card findById(int id);

    @Query("SELECT M FROM Card M where M.person.id = ?1 and M.flagActive = true")
    List<Card> findIdPersona(int id);

    @Query("SELECT M FROM Card M where M.person.id = ?1 and M.digits = ?2 and M.flagActive = true")
    Card findByPersonaIdByDigits(int id, String number);

    @Query("SELECT C.person.id FROM Card C where C.id = ?1")
    int getPersonIdById(int id);
}