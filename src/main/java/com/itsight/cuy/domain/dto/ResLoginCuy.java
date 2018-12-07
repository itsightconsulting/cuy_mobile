package com.itsight.cuy.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class ResLoginCuy implements Serializable {

    private String oauthToken;

    private BigInteger oauthTokenExpiresAt;

    private String code;
    private String status;
    private DtLogin data;

    public ResLoginCuy(){
        this.data = new DtLogin();
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public BigInteger getOauthTokenExpiresAt() {
        return oauthTokenExpiresAt;
    }

    public void setOauthTokenExpiresAt(BigInteger oauthTokenExpiresAt) {
        this.oauthTokenExpiresAt = oauthTokenExpiresAt;
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

    public DtLogin getData() {
        return data;
    }

    public void setData(DtLogin data) {
        this.data = data;
    }
}
