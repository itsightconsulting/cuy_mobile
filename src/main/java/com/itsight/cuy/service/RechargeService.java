package com.itsight.cuy.service;

import com.itsight.cuy.domain.Recharge;
import com.itsight.cuy.generic.BaseService;

import java.util.List;

public interface RechargeService extends BaseService<Recharge> {

    List<Recharge> findAllByNumber(String phoneNumber);

}
