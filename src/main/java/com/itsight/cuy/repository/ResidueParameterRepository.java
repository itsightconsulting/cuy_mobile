package com.itsight.cuy.repository;

import com.itsight.cuy.domain.ResidueParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResidueParameterRepository extends JpaRepository<ResidueParameter, Integer> {
}
