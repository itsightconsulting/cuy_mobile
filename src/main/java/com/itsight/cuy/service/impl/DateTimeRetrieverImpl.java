package com.itsight.cuy.service.impl;

import com.itsight.cuy.service.DateTimeRetriever;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class DateTimeRetrieverImpl implements DateTimeRetriever {

    @Override
    public Date currentTime() {
        return new Timestamp(System.currentTimeMillis());
    }
}