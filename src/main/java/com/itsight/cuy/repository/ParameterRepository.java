package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter,Integer> {

    List<Parameter> findAll();
}