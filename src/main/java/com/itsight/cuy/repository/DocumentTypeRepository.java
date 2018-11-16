package com.itsight.cuy.repository;

import com.itsight.cuy.domain.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType,Integer> {
    List<DocumentType> findAll();
    DocumentType findById(int id);


    @Query("SELECT M FROM DocumentType M where M.flagActive = ?1")
    List<DocumentType> findAllbyFlagActivo(boolean estado);
}