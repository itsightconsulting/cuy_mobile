package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Integer> {
    List<Operator> findAll();

    Operator findById(int id);

    @Query("SELECT M FROM Operator M where M.flagActive = ?1")
    List<Operator> findAllbyFlagActivo(boolean estado);
}