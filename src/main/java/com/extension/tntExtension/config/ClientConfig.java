package com.extension.tntExtension.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    private static String projectKey = "sunrisedata";
    private static String client_id = "dR66htzM25s-XmF_Nz7oGzou";
    private static String client_secret = "GgLB-pLF6I8zpTD-xeNqWCD7XGGOm7V9";
    @Bean
    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId(client_id)
                                .withClientSecret(client_secret)
                                .build(),
                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build(projectKey);

        return apiRoot;
    }
}


