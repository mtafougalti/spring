package com.mt.spring.resourceserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("security")
@Data
public class SecurityProperties {

    private JwtProperties jwt;
    @Data
    public static class JwtProperties {
        private Resource publicKey;
    }

}