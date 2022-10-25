package com.umbrellait.keycloakauthenticator;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.authenticators.broker.IdpCreateUserIfUniqueAuthenticatorFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.ArrayList;
import java.util.List;

public class EnableIfRequireFactory extends IdpCreateUserIfUniqueAuthenticatorFactory {

    private static final String PROVIDER_ID = "idp-enable-user-if-require";
    private static final String REQUIRE_PASSWORD_UPDATE_AFTER_REGISTRATION = "require.password.update.after.registration";
    private static final List<ProviderConfigProperty> configProperties = new ArrayList<>();
    private static final EnableIfRequire SINGLETON = new EnableIfRequire();

    @Override
    public Authenticator create(KeycloakSession session) {
        return SINGLETON;
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getDisplayType() {
        return "Enable User When Require";
    }

    @Override
    public String getHelpText() {
        return "Enable user when require";
    }

    @Override
    public void init(Config.Scope config) { }

    static {
        ProviderConfigProperty property;
        property = new ProviderConfigProperty();
        property.setName(REQUIRE_PASSWORD_UPDATE_AFTER_REGISTRATION);
        property.setLabel("Require Password Update");
        property.setType(ProviderConfigProperty.BOOLEAN_TYPE);
        property.setHelpText("You are required to update password when user will be created");
        configProperties.add(property);
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return configProperties;
    }
}