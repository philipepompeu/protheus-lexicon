package com.philipepompeu.protheus_lexicon_backend.multitenancy;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

@Component
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl<String>  {

    private final DataSource defaultDataSource;

    @Autowired
    public MultiTenantConnectionProviderImpl(DataSource dataSource) {
        System.out.println("? MultiTenantConnectionProviderImpl inicializado!");
        this.defaultDataSource = dataSource;
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return defaultDataSource;
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        // Aqui você pode buscar o DataSource correspondente ao tenantIdentifier
        // Por exemplo, carregar dinâmicamente com base em um mapa ou banco de dados        
        System.out.println(String.format("tenantId selecionado:[ %s ]", (String) tenantIdentifier));
        return defaultDataSource; // Exemplo: Retornando o mesmo DataSource para todos os tenants
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        final Connection connection = defaultDataSource.getConnection();
        connection.setSchema(tenantIdentifier); // Define o schema do tenant
        return connection;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return defaultDataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.close();
    }

  

  
}


