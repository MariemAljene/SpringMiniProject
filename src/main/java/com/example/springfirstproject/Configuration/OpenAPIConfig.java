package com.example.springfirstproject.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {


        @Bean
        public OpenAPI springShopOpenAPI() {
            return new OpenAPI()
                    .info(infoAPI());
        }
        public Info infoAPI() {
            return new Info().title("Projet Khadem")
                    .description("TP étude de cas")
                    .contact(contactAPI());
        }
        public Contact contactAPI() {
            Contact contact = new Contact().name("Equipe ASI II")
                            .email("mariem.aljene@esprit.tn")
                    .url("https://www.linkedin.com/in/**********/");
            return contact;
        }

}
