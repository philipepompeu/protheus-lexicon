package com.philipepompeu.protheus_lexicon_backend.domain;

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
@Table(name = "SX3T10") // Exemplo: Tabela de campos no Protheus
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class FieldEntity {
    
    @Id
    @Column(name = "X3_CAMPO")
    private String field;

    @Column(name = "X3_TIPO")
    private String type;

    @Column(name = "X3_TAMANHO")
    private Integer size;

    @Column(name = "X3_DECIMAL")
    private Integer decimal;

    @Column(name = "X3_TITULO")
    private String title;

    @Column(name = "X3_DESCRIC")
    private String description;
    
    @Column(name = "X3_VALID")
    private String valid;
    
    @Column(name = "X3_RELACAO")
    private String init;
    
    @Column(name = "X3_WHEN")
    private String when;
    
    @Column(name = "X3_ORDEM")
    private String sequence;


    @ManyToOne
    @JoinColumn(name = "X3_ARQUIVO", referencedColumnName = "X2_CHAVE")
    private TableEntity table;
}
