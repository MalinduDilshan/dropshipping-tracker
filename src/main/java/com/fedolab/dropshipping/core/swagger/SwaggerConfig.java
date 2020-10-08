package com.fedolab.dropshipping.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi()
    {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.fedolab.inventory.component"))
                .paths(regex("/.*")).build().apiInfo(metaData());
    }

    private ApiInfo metaData()
    {

        ApiInfo apiInfo = new ApiInfo("Dropshipping Spring Boot App", "Spring Boot REST API", "1.0",
                "Terms of service",
                new Contact("FEDO-LAB", "http://fedolab.co.nf/", "fedolabsoft@gmail.com"),
                " License Version 1.0", "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
