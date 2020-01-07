package com.mt.spring.authserver.config;

import lombok.Data;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("security")
@Data
public class SecurityProperties {

    private JwtProperties jwt;

    @Data
    public static class JwtProperties {
        private Resource keyStore;
        private String keyStorePassword;
        private String keyPairAlias;
        private String keyPairPassword;
    }
}
