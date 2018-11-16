package com.itsight.cuy.repository;

import com.itsight.cuy.domain.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanTypeRepository extends JpaRepository<PlanType,Integer> {
    List<PlanType> findAll();
    PlanType findById(int id);

    @Query("SELECT M FROM PlanType M where M.flagActive = ?1")
    List<PlanType> findAllbyFlagActivo(boolean estado);

}