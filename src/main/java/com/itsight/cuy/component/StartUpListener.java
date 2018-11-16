package com.itsight.cuy.component;

import com.itsight.cuy.domain.*;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.itsight.cuy.domain.jsonb.Residue;
import com.itsight.cuy.domain.oauth.OauthClientDetails;
import com.itsight.cuy.repository.OauthClientDetailsRepository;
import com.itsight.cuy.repository.ResidueParameterRepository;
import com.itsight.cuy.repository.SecurityUserRepository;
import com.itsight.cuy.service.*;
import com.itsight.cuy.util.Enums;
import com.itsight.cuy.util.Utilitarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.*;

@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private PersonTypeService personTypeService;

    @Autowired
    private CardTypeService tipoTarjetaService;

    @Autowired
    private PersonService personService;

    @Autowired
    private CardService cardService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private PlanService planService;

    @Autowired
    private PlanTypeService planTypeService;

    @Autowired
    private PersonPlanService personPlanService;

    @Autowired
    private ResidueParameterRepository residueParameterRepository;

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

        if(documentTypeService.findOne(1) == null){
            addingTipoDocumentoToTable();
            addingTipoPersonaToTable();
            addingTipoTarjetaToTable();
            addingPersonaToTable();
            addingTarjetaToTable();
            addingOperadorToTable();
            addingPlanTypeToTable();
            addingPlanToTable();
            addingPersonPlanToTable();
            addingResidueRanges();
        }

        addingToContextSession();
        addingInitUsers();
        creatingFileDirectories();
    }

    public void addingTipoDocumentoToTable(){
        if(documentTypeService.findOne(1) == null) documentTypeService.save(new DocumentType("DNI",true,"AUTO",new Date()));
        if(documentTypeService.findOne(2) == null) documentTypeService.save(new DocumentType("CE",true,"AUTO",new Date()));
    }

    public void addingTipoPersonaToTable(){
        if(personTypeService.findOne(1) == null) personTypeService.save(new PersonType("Natural",true,"AUTO",new Date()));
        if(personTypeService.findOne(2) == null) personTypeService.save(new PersonType("Juridica",true,"AUTO",new Date()));
    }

    public void addingTipoTarjetaToTable(){
        if(tipoTarjetaService.findOne(1) == null) tipoTarjetaService.save(new CardType("Visa",true,"AUTO",new Date()));
        if(tipoTarjetaService.findOne(2) == null) tipoTarjetaService.save(new CardType("Master Card",true,"AUTO",new Date()));
    }

    public void addingPersonaToTable(){
        Preferences prefs = new Preferences();
        List<com.itsight.cuy.domain.jsonb.Residue> residuesPrefs = new ArrayList<>();
        residuesPrefs.add(new com.itsight.cuy.domain.jsonb.Residue(15, "Plan Chihuan"));residuesPrefs.add(new com.itsight.cuy.domain.jsonb.Residue(21, "Plan Salvador"));residuesPrefs.add(new com.itsight.cuy.domain.jsonb.Residue(33, "Plan mini"));residuesPrefs.add(new Residue(49, "Plan cool"));
        prefs.setResidues(residuesPrefs);

        if(personService.findOne(1) == null) personService.save(new Person("Jean",1,1,"74148876",true,"AUTO",new Date(), prefs));
        if(personService.findOne(2) == null) personService.save(new Person("Master",1,1,"48982398",true,"AUTO",new Date(), prefs));
    }

    public void addingTarjetaToTable(){
        if(cardService.findOne(1) == null) cardService.save(new Card(1,1,"234643242346",new Date(),"3243","full",true,"AUTO",new Date()));
        if(cardService.findOne(2) == null) cardService.save(new Card(2,1,"983498548923",new Date(),"6611","small",true,"AUTO",new Date()));
    }

    public void addingOperadorToTable(){
        if(operatorService.findOne(1) == null) operatorService.save(new Operator("Claro",true,"AUTO",new Date()));
        if(operatorService.findOne(2) == null) operatorService.save(new Operator("Otros",true,"AUTO",new Date()));
    }

    public void addingPlanTypeToTable(){
        if(planTypeService.findOne(1) == null) planTypeService.save(new PlanType("PLAN 30", true, Enums.SubPlanType.POSTPAGO));
        if(planTypeService.findOne(2) == null) planTypeService.save(new PlanType("PLAN 99", true, Enums.SubPlanType.POSTPAGO));
        if(planTypeService.findOne(3) == null) planTypeService.save(new PlanType("Prepago", true, Enums.SubPlanType.PREPAGO));
    }

    public void addingPlanToTable(){
        if(planService.findOne(1) == null) planService.save(new Plan("Plan postpago",30, 1234.12, 9000, new BigDecimal(49020.31),  1));
        if(planService.findOne(2) == null) planService.save(new Plan("Plan postpago",90, 1234.12, 9000, new BigDecimal(98299.52),  2));
    }

    public void addingPersonPlanToTable(){
        if(personPlanService.findOne(1) == null) personPlanService.save(new PersonPlan(1, 1));
    }

    public void addingResidueRanges(){
        Optional<ResidueParameter> residueOptional =  residueParameterRepository.findById(new Integer(1));
        if(!residueOptional.isPresent()){
            ResidueParameter r1min = new ResidueParameter();
            r1min.setAmount(3);
            r1min.setRange(Enums.ResidueRanges.MINIMO);
            residueParameterRepository.save(r1min);
        }

        if(!residueOptional.isPresent()){
            ResidueParameter r2max = new ResidueParameter();
            r2max.setAmount(100);
            r2max.setRange(Enums.ResidueRanges.MAXIMO);
            residueParameterRepository.save(r2max);
        }
    }

    public void addingToContextSession() {
        context.setAttribute("version", currentVersion);
    }

    public void addingInitUsers() {
        SecurityUser securityUser = userRepository.findByUsername("cuy_admin");
        if (securityUser == null) {
            SecurityUser secUser = new SecurityUser();
            secUser.setUsername("cuy_admin");
            secUser.setPassword(new BCryptPasswordEncoder().encode("@dmin@2018"));
            secUser.setEnabled(true);
            Set<SecurityRole> roles = new HashSet<>();
            roles.add(new SecurityRole("ROLE_SUPER_ADMIN"));
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