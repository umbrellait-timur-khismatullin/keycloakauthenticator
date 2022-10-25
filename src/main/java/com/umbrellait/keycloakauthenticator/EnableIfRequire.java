package com.umbrellait.keycloakauthenticator;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.authenticators.broker.IdpCreateUserIfUniqueAuthenticator;
import org.keycloak.authentication.authenticators.broker.util.SerializedBrokeredIdentityContext;
import org.keycloak.broker.provider.BrokeredIdentityContext;
import org.keycloak.models.UserModel;

public class EnableIfRequire extends IdpCreateUserIfUniqueAuthenticator {
    @Override
    protected void userRegisteredSuccess(AuthenticationFlowContext context,
                                         UserModel registeredUser,
                                         SerializedBrokeredIdentityContext serializedCtx,
                                         BrokeredIdentityContext brokerContext) {
        if (!registeredUser.getEmail().endsWith("@umbrellait.com")) {
            registeredUser.setEnabled(false);
        }
    }
}
