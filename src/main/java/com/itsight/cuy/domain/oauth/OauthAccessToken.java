package com.itsight.cuy.domain.oauth;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
public class OauthAccessToken {
    @Id
    private String tokenId;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(nullable = false)
    private byte[] token;
    @Column(nullable = false)
    private String authenticationId;
    @Column()
    private String userName;
    @Column(nullable = false)
    private String clientId;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(nullable = false)
    private byte[] authentication;
    @Column
    private String refreshToken;
}
