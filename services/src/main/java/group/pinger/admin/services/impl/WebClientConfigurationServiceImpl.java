package group.pinger.admin.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import group.pinger.admin.services.WebClientConfigurationService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WebClientConfigurationServiceImpl implements WebClientConfigurationService {
    
    @Override
    public String generateWebClientConfiguration() {
        ObjectMapper objectMapper = new ObjectMapper();
    
        ObjectNode rootNode = objectMapper.createObjectNode();
    
        rootNode.put("production", isProductionEnv());
        
        ObjectNode keycloakNode = createKeycloakNode(objectMapper);
        rootNode.set("keycloak", keycloakNode);
        
        ObjectNode apisNode = createApisNode(objectMapper);
        rootNode.set("apis", apisNode);
    
        try {
            return objectMapper.writeValueAsString(rootNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
    
    private ObjectNode createKeycloakNode(ObjectMapper objectMapper) {
        ConfigurationUtil configUtil = ConfigurationUtil.getInstance();
        ObjectNode node = objectMapper.createObjectNode();
        
        node.put("realm", configUtil.get("keycloak.realm").orElse(null));
        node.put("url", configUtil.get("keycloak.auth-server-url").orElse(null));
        node.put("clientId", configUtil.get("web.client-id").orElse(null));
        
        return node;
    }
    
    private ObjectNode createApisNode(ObjectMapper objectMapper) {
        ObjectNode node = objectMapper.createObjectNode();
    
        node.set("supervisor", createApiNode(objectMapper, ""));
    
        return node;
    }
    
    private ObjectNode createApiNode(ObjectMapper objectMapper, String url) {
        ObjectNode node = objectMapper.createObjectNode();
        node.put("url", url);
        return node;
    }
    
    private ObjectNode createApiNode(ObjectMapper objectMapper, String url, String apiKey) {
        ObjectNode node = createApiNode(objectMapper, url);
        node.put("apiKey", apiKey);
        return node;
    }
    
    private boolean isProductionEnv() {
        return ConfigurationUtil.getInstance().getBoolean("kumuluzee.env.prod").orElse(false);
    }
}
