package com.philipepompeu.protheus_lexicon_backend.domain;

import java.math.BigInteger;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SX6T10")
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class ParameterEntity {


    public ParameterEntity() {
    }  

    @Id
    @Column(name = "R_E_C_N_O_")
    private BigInteger id;

    @Column(name = "X6_VAR")
    private String name;

    @Column(name = "X6_TIPO")
    private String type;

    @Column(name = "X6_CONTEUD")
    private String value;

    @Column(name = "X6_DEFPOR")
    private String defaultValue = "";

    @Column(name = "X6_PROPRI")
    private String owner;

    @Column(name = "X6_DESCRIC")
    private String descriptionPart1 = "";

    @Column(name = "X6_DESC1")
    private String descriptionPart2 = "";

    @Column(name = "X6_DESC2")
    private String descriptionPart3 = "";

    @Transient
    private String description;

    @PostLoad
    private void postLoad() {
        this.description = String.format("%s %s %s", descriptionPart1.trim(), descriptionPart2.trim(), descriptionPart3.trim()).trim();
        this.defaultValue = this.defaultValue.trim();
    }


}
