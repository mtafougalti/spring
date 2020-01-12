package com.mt.spring.oauthokta.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties("swagger.security.oauth2.implicit")
@Data
@Component
public class SwaggerProperties {
    private String clientId;
    private String clientSecret;
    private String authorizeEndpoint;
    private String nonce;
    private List<String> scopes;
}
