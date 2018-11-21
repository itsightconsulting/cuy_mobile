package com.itsight.cuy.service;

import com.itsight.cuy.domain.Operator;
import com.itsight.cuy.domain.Transaction;
import com.itsight.cuy.generic.BaseService;

import java.util.List;

public interface TransactionService extends BaseService<Transaction> {

    List<Transaction> findTop20ByPersonId(int personId);

    Transaction findByCodeTransaction(String code);

}