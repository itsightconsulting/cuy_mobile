package com.itsight.cuy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
/*
@Configuration
@EnableResourceServer
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource ouathDataSource(){return DataSourceBuilder.create().build();}

    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        TokenStore tokenStore=new JdbcTokenStore(ouathDataSource());
        resources.resourceId("cuy_api").tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/auth/token**").permitAll();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/cuy/**").access("#oauth2.hasScope('read')");
    }
}*/
