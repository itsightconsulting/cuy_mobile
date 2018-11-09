package com.itsight.cuy.component;

import com.itsight.cuy.domain.SecurityRole;
import com.itsight.cuy.domain.SecurityUser;
import com.itsight.cuy.domain.oauth.OauthClientDetails;
import com.itsight.cuy.repository.OauthClientDetailsRepository;
import com.itsight.cuy.repository.SecurityUserRepository;
import com.itsight.cuy.util.Utilitarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SecurityUserRepository userRepository;

    @Autowired
    private OauthClientDetailsRepository oauthClientDetailsRepository;

    @Autowired
    private ServletContext context;

    @Value("${main.repository}")
    private String mainRoute;

    private final Long currentVersion = new Date().getTime();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        addingToContextSession();
        addingInitUsers();
        creatingFileDirectories();
    }

    public void addingToContextSession() {
        context.setAttribute("version", currentVersion);
    }

    public void addingInitUsers() {
        SecurityUser securityUser = userRepository.findByUsername("admin");
        if (securityUser == null) {
            SecurityUser secUser = new SecurityUser();
            secUser.setUsername("admin");
            secUser.setPassword(new BCryptPasswordEncoder().encode("@dmin@2018"));
            secUser.setEnabled(true);
            Set<SecurityRole> roles = new HashSet<>();
            roles.add(new SecurityRole("ROLE_ADMIN"));
            secUser.setRoles(roles);
            userRepository.save(secUser);
        } else
            System.out.println("> Record already exist <");


        //Init application's client
        Optional<OauthClientDetails> outhCliVal =  oauthClientDetailsRepository.findById("cuy_mobile");
        if(!outhCliVal.isPresent()){
            OauthClientDetails oauthCli = new OauthClientDetails();
            oauthCli.setClientId("cuy_mobile");
            oauthCli.setResourceIds("cuy_api");
            oauthCli.setClientSecret(new BCryptPasswordEncoder().encode("user"));
            oauthCli.setScope("read,write");
            oauthCli.setAuthorizedGrantTypes("client_credentials");
            oauthCli.setWebServerRedirectUri("http://127.0.0.1");
            oauthCli.setAuthorities("ROLE_CUY_ADMIN");
            oauthCli.setAccessTokenValidity(600);
            oauthCli.setRefreshTokenValidity(0);
            //https://stackoverflow.com/questions/43676734/spring-oauth2-cant-get-additional-information-from-clientdetailsservice
            oauthCli.setAdditionalInformation("{\"Info\":\"Cuy Api\"}");
            oauthCli.setAutoapprove("true");
            oauthClientDetailsRepository.save(oauthCli);
        }else
            System.out.println("INIT APPLICATION'S CLIENT ALREADY EXISTS");


    }

    public void creatingFileDirectories() {
        String[] childPaths = {};
        Utilitarios.createDirectoryStartUp(mainRoute, childPaths);
    }
}
