package com.itsight.cuy.domain.dto;

import com.itsight.cuy.domain.ResRechargeCuy;

import java.io.Serializable;

public class ResBaseRechargeCuy implements Serializable {

    private String code;
    private String status;
    private ResRechargeCuy data;
    private String pageKey;
    private Object list;

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

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
