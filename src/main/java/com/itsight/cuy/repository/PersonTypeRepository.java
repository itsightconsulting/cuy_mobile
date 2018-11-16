package com.itsight.cuy.repository;

import com.itsight.cuy.domain.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonTypeRepository extends JpaRepository<PersonType,Integer> {
    List<PersonType> findAll();
    PersonType findById(int id);

    @Query("SELECT M FROM PersonType M where M.flagActive = ?1")
    List<PersonType> findAllbyFlagActivo(boolean estado);
}