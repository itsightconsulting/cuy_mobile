package com.itsight.cuy.domain.oauth;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OauthCode {

    @Id
    private String code;

    @Column(nullable = false)
    private String authentication;

}
