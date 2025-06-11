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
@Table(name = "SIXT10")
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class IndexEntity {
    @Id
    @Column(name = "R_E_C_N_O_")
    private BigInteger id;

    @Column(name = "ORDEM")
    private String sequence;
    
    @Column(name = "CHAVE")
    private String key;
    
    @Column(name = "DESCRICAO")
    private String description;

    @ManyToOne
    @JoinColumn(name = "INDICE", referencedColumnName = "X2_CHAVE")
    private TableEntity table;
    
}
