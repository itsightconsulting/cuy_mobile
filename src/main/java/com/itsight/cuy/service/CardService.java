package com.itsight.cuy.service;

import com.itsight.cuy.domain.Card;
import com.itsight.cuy.generic.BaseService;

import java.util.List;

public interface CardService extends BaseService<Card> {

    List<Card> findIdPersona(int id);

    Card findByPersonaIdByDigits(int id, String number);

    int getPersonIdById(int id);
}