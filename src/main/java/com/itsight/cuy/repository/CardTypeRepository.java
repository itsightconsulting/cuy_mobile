package com.itsight.cuy.repository;

import com.itsight.cuy.domain.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType,Integer> {
    List<CardType> findAll();
    CardType findById(int id);

    @Query("SELECT M FROM CardType M where M.flagActive = ?1")
    List<CardType> findAllbyFlagActivo(boolean estado);
}