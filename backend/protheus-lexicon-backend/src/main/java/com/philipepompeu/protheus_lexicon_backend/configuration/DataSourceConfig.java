package com.philipepompeu.protheus_lexicon_backend.configuration;

import com.philipepompeu.protheus_lexicon_backend.multitenancy.TenantSchemaResolver;
import com.philipepompeu.protheus_lexicon_backend.multitenancy.MultiTenantConnectionProviderImpl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;


import java.util.HashMap;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String defaultUrl;

    @Value("${spring.datasource.username}")
    private String defaultUsername;

    @Value("${spring.datasource.password}")
    private String defaultPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    //@Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(defaultUrl);
        config.setUsername(defaultUsername);
        config.setPassword(defaultPassword);
        config.setDriverClassName(driverClassName);
        return (DataSource) new HikariDataSource(config);
    }

    //@Bean
    public MultiTenantConnectionProvider<String> multiTenantConnectionProvider(DataSource dataSource) {
        return new MultiTenantConnectionProviderImpl(dataSource);
    }

    //@Bean
    public CurrentTenantIdentifierResolver<String> tenantIdentifierResolver() {
        return new TenantSchemaResolver();
    }

    //@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,        
            MultiTenantConnectionProvider<String> multiTenantConnectionProvider,
            CurrentTenantIdentifierResolver<String> tenantIdentifierResolver) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.philipepompeu.protheus_lexicon_backend.entity");         
        
        //em.setPersistenceUnitName("P1212410MNTDBEXP");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> properties = new HashMap<>();        
        
        //properties.put("hibernate.multiTenancy", "SCHEMA"); // Certifique-se de que essa configuraзгo seja necessбria
        properties.put("hibernate.tenant_identifier_resolver", multiTenantConnectionProvider);
        properties.put("hibernate.multi_tenant_connection_provider", tenantIdentifierResolver);
        em.setJpaPropertyMap(properties);

        return em;
    }

     //@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
 
