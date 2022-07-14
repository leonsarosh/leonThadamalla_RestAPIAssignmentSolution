package leon.springboot.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket EmployeeManagementApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Employee-Management-API").select()
				.apis(RequestHandlerSelectors.basePackage("leon.springboot.restapi.controller")).build();
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Employee Management API")
				.description("Employee Management API reference for developers").termsOfServiceUrl("http://fakexyz.com")
				.contact(new Contact("Employee Management API", "http://fakexyz.com", "fakexyz@abc.com"))
				.license("Employee Management license").licenseUrl("http://fakexyz.com").version("1.0").build();
	}
}
