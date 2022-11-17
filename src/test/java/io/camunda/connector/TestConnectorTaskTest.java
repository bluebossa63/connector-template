package io.camunda.connector;

import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;
import io.zeebe.client.ZeebeClient;
import io.zeebe.client.impl.ZeebeClientImpl;
import io.zeebe.client.impl.oauth.OAuthCredentialsProvider;

public class TestConnectorTaskTest {

    private static final String zeebeAPI = "[Zeebe API]";
  private static final String clientId = "[Client ID]";
  private static final String clientSecret = "[Client Secret]";
  private static final String oAuthAPI = "[OAuth API] ";

    public void testConnector() {

        OAuthCredentialsProvider credentialsProvider =
        new OAuthCredentialsProviderBuilder()
            .authorizationServerUrl(oAuthAPI)
            .audience(zeebeAPI)
            .clientId(clientId)
            .clientSecret(clientSecret)
            .build();

    try (ZeebeClient client = ZeebeClient.newClientBuilder()
            .gatewayAddress(zeebeAPI)
            .credentialsProvider(credentialsProvider)
            .build()) {
      client.newTopologyRequest().send().join();
    }
    }    
}
