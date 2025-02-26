package com.philipepompeu.protheus_lexicon_backend.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class QuestionEntity {


    public QuestionEntity() {
    }  

    @Id    
    @Column(name = "X1_GRUPO")
    private String name;   

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "X1_GRUPO", referencedColumnName = "X1_GRUPO")
    private List<QuestionItem> items = new ArrayList<>();


    @PostLoad
    private void postLoad() {
        this.name = this.name.trim();
    }

}

