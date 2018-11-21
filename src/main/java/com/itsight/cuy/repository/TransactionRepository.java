package com.itsight.cuy.repository;

import com.itsight.cuy.domain.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAll();

    Transaction findById(int id);

    @Query("SELECT M FROM Transaction M where M.flagActive = ?1")
    List<Transaction> findAllbyFlagActivo(boolean estado);

    //@Query("SELECT M FROM Transaction M JOIN FETCH M.person P LEFT JOIN FETCH M.recharge R  where M.person.id = ?1")

    @EntityGraph(value = "transaction.all")
    List<Transaction> findTop20ByPersonId(int id);

    @Query("SELECT M FROM Transaction M where M.codeTransaction = ?1")
    Transaction findByCodeTransaction(String code);

}