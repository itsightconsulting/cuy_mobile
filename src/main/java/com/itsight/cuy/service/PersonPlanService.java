package com.itsight.cuy.service;

import com.itsight.cuy.domain.PersonPlan;
import com.itsight.cuy.generic.BaseService;

import java.util.List;

public interface PersonPlanService extends BaseService<PersonPlan> {

    List<PersonPlan> findByPersonId(int personId);
}
