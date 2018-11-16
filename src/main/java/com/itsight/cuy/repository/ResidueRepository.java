package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Residue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidueRepository extends JpaRepository<Residue,Integer> {
    List<Residue> findAll();
    Residue findById(int id);
}