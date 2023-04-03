package com.extension.tntExtension.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientConfigTest {

    @Test
    void createApiClient() {
        ProjectApiRoot projectApiRoot = ClientConfig.createApiClient();
        Project project = projectApiRoot.get().executeBlocking().getBody();
        assertEquals("sunrisedata",project.getKey());
    }
}