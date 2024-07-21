package com.mensajeria.escolar;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolarApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("EDU NOTIFY")
						.version("0.01")
						.description("Prueba de endpoints")
						.termsOfService("https://swagger.io/terms/")
						.license(new License().name("S16-26")));
	}

}
