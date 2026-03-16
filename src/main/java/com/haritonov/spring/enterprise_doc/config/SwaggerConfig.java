package com.haritonov.spring.enterprise_doc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI enterpriseDocOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Enterprise Doc API")
                        .description("Система учета документов. " +
                                "Микросервисная архитектура на Spring Boot + PostgreSQL.")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Nikita")
                                .email("nikita.harit@mail.ru")
                                .url("https://github.com/Rgl-RogueLike"))
                );
    }
}
