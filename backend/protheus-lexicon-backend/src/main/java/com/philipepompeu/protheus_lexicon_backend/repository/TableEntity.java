package com.philipepompeu.protheus_lexicon_backend.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SX2T10")
public class TableEntity {


    @Id
    @Column(name = "X2_CHAVE", nullable = false, length = 50)
    private String id;

    @Column(name = "X2_NOME", nullable = false, length = 255)
    private String description;

    @Column(name = "X2_UNICO", nullable = false, length = 255)
    private String primaryKey;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getPrimaryKey() {
        return primaryKey;
    }
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

}
