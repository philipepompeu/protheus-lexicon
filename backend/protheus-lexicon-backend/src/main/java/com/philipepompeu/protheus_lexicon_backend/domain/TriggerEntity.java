package com.philipepompeu.protheus_lexicon_backend.domain;
import java.math.BigInteger;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SX7T10")
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class TriggerEntity {
    @Id
    @Column(name = "R_E_C_N_O_")
    private BigInteger id;

    @Column(name = "X7_SEQUENC")
    private String sequence;
    
    @Column(name = "X7_CDOMIN")
    private String updatedField;
    
    @Column(name = "X7_CONDIC")
    private String executionCondition;
    
    @Column(name = "X7_REGRA")
    private String instructionToBeExecuted;
    
    @Column(name = "X7_PROPRI")
    private String owner;

    @ManyToOne
    @JoinColumn(name = "X7_CAMPO", referencedColumnName = "X3_CAMPO")
    private FieldEntity field;
    
}
