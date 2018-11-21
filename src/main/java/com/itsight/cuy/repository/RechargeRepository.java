package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Integer> {

    List<Recharge> findAllByNumber(String phoneNumber);
    Recharge findById(int id);
    List<Recharge> findAll();
}
