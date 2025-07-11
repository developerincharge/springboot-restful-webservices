package com.rizvi.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
       info = @Info(
			   title = "Spring Boot Restful Webservices",
			   version = "1.0",
			   description = "Spring Boot Restful Webservices Documentation",
			   contact = @Contact(
					   name = "Rizvi",
					   email = "syed@developers.com",
					   url = "https://www.developers.com"
       ),
			   license = @License(
					   name = "Apache 2.0",
					   url = "https://www.apache.org/licenses/LICENSE-2.0"
			   )
    ),
	   externalDocs = @ExternalDocumentation(
			   description = "Spring Boot User Management Documentation",
			   url = "https://www.developers.com"
	   )
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
