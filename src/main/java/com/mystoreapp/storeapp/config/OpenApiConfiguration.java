package com.mystoreapp.storeapp.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Store Api Documentation",
                version = "V1.0",
                description = "Test API",
                contact = @Contact(name = "Ahmed Ismail",email = "ahmed.ismaeel@intelligentprojects.net"),
                license = @License(name = "MIT License"),
                termsOfService = "Terms Of Service"

        ),
        security = @SecurityRequirement( name="bearerType" ))
@SecurityScheme(
        name = "bearerType",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer")
public class OpenApiConfiguration {
}
