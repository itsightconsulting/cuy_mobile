package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.Transaction;
import com.itsight.cuy.domain.dto.TransactionDTO;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.TransactionRepository;
import com.itsight.cuy.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl extends BaseServiceImpl<TransactionRepository> implements TransactionService {

    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }

    @Override
    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public Transaction update(Transaction entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Transaction findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Transaction findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAllbyFlagActivo(true);
    }

    @Override
    public List<Transaction> findTop20ByPersonId(int personId) {
        return repository.findTop20ByPersonId(personId);
    }

    @Override
    public Transaction findByCodeTransaction(String code) {
        return repository.findByCodeTransaction(code);
    }


}
