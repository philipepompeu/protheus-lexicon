package com.philipepompeu.protheus_lexicon_backend.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver<String> {

    private static final String DEFAULT_TENANT = "public"; // Define o schema padr�o

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        return (tenant != null) ? tenant : DEFAULT_TENANT; // Usa "public" como padr�o
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}

