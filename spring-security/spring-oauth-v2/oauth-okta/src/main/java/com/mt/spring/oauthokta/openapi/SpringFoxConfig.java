package com.mt.spring.oauthokta.openapi;

import com.mt.spring.oauthokta.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mt.spring.oauthokta.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title("Tasks Management API")
                .description("Tasks Management REST API")
                .contact(new Contact("Mostafa TAFOUGALTI", "www.mt.com", "mtafougalti@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        Map<String, Object> additionalQueryStringParams=new HashMap<>();
        additionalQueryStringParams.put("nonce",swaggerProperties.getNonce());
        return SecurityConfigurationBuilder.builder()
                .clientId(swaggerProperties.getClientId())
                .clientSecret(swaggerProperties.getClientSecret())
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .additionalQueryStringParams(additionalQueryStringParams)
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("spring_oauth", scopes().toArray(new AuthorizationScope[0]))))
                .forPaths(PathSelectors.any())
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new ImplicitGrant(new LoginEndpoint( swaggerProperties.getAuthorizeEndpoint()), OAuth2AccessToken.ACCESS_TOKEN);

        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
                .grantTypes(Arrays.asList(grantType))
                .scopes(scopes())
                .build();
        return oauth;
    }

    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> scopes = new ArrayList<>();
        swaggerProperties.getScopes().forEach(scope -> {
            scopes.add(new AuthorizationScope(scope, scope));
        });
        return scopes;
    }
}
