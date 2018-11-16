package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itsight.cuy.domain.base.AuditingEntity;
import com.itsight.cuy.util.Enums;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class PlanType extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlanTypeId")
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planType")
    private List<Plan> lstPlan;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Enums.SubPlanType subPlanType;

    public Enums.SubPlanType getSubPlanType() {
        return subPlanType;
    }

    public void setSubPlanType(Enums.SubPlanType subPlanType) {
        this.subPlanType = subPlanType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getLstPlan() {
        return lstPlan;
    }

    public void setLstPlan(List<Plan> lstPlan) {
        this.lstPlan = lstPlan;
    }

    public PlanType(int id) {
        this.id = id;
    }

    public PlanType(String name) {
        this.name = name;
    }

    public PlanType(String name, boolean flag, Enums.SubPlanType subPlanType) {
        this.name = name;
        this.setFlagActive(flag);
        this.subPlanType = subPlanType;
    }
    
    public PlanType(int id, boolean flag, String createdBy, Date date) {
        this.id = id; 
        this.setFlagActive(flag); 
        this.setCreatedBy(createdBy); setCreationDate(date);
    }

    public PlanType() { }
}
