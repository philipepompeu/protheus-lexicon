package com.philipepompeu.protheus_lexicon_backend.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SX2T10")
@SQLRestriction("D_E_L_E_T_ = ' '")
@Immutable
@Getter
@Setter
public class TableEntity {


    public TableEntity() {
    }
    public TableEntity(String id, String description, String primaryKey) {
        this.id = id;
        this.description = description;
        this.primaryKey = primaryKey;
    }

    @Id
    @Column(name = "X2_CHAVE", nullable = false, length = 50)
    private String id;

    @Column(name = "X2_NOME", nullable = false, length = 255)
    private String description;

    @Column(name = "X2_UNICO", nullable = false, length = 255)
    private String primaryKey;

}
