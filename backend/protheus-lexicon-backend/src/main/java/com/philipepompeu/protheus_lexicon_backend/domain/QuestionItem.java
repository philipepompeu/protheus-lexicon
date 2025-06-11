package com.philipepompeu.protheus_lexicon_backend.domain;

import java.math.BigInteger;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SX1T10")
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class QuestionItem {

    @Id
    @Column(name = "R_E_C_N_O_")
    private BigInteger id;    

    @Column(name = "X1_ORDEM")
    private String sequence;

    @Column(name = "X1_PERGUNT")
    private String questionText;

    @Column(name = "X1_TIPO")
    private String type;

    @Column(name = "X1_TAMANHO")
    private Double size;

    @Column(name = "X1_DECIMAL")
    private Double decimal;
    
    @Column(name = "X1_VALID")
    private String valid;

    // Getters e Setters

    @PostLoad
    private void postLoad() {
        this.questionText = this.questionText.trim();
        this.valid = this.valid.trim();
    }
}

