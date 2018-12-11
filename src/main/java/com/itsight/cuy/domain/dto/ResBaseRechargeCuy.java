package com.itsight.cuy.domain.dto;

import com.itsight.cuy.domain.ResRechargeCuy;

import java.io.Serializable;

public class ResBaseRechargeCuy implements Serializable {

    private String code;
    private String status;
    private ResRechargeCuy data;

    public ResBaseRechargeCuy(){
        this.data = new ResRechargeCuy();
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

    public ResRechargeCuy getData() {
        return data;
    }

    public void setData(ResRechargeCuy data) {
        this.data = data;
    }
}
