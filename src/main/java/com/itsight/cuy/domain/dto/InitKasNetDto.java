package com.itsight.cuy.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class InitKasNetDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -5406840367489412469L;

    private String code;
    private String status;
    private Object data;
    private Object problems;
    private String message;


    public InitKasNetDto() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getProblems() {
        return problems;
    }

    public void setProblems(Object problems) {
        this.problems = problems;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
