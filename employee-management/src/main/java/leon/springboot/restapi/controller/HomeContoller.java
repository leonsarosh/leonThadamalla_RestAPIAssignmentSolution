package leon.springboot.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {
	
	@GetMapping("/")
	public String homePage() {
		return ("<h1>Welcome to Employee Management</h1> <hr>\r\n"
				+ "		<a href=\"/swagger-ui.html\">Employee Management API access</a> ");
	}
}
