package leon.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import leon.springboot.restapi.model.EmpUser;
import leon.springboot.restapi.service.EmpUserService;

@RestController
public class UserController {

	@Autowired
	private EmpUserService userService;

	@PostMapping("/addEmpUser")
	public void addEmpUser(String userName, String password, String roleName) {
		userService.addEmpUser(userName, password, roleName);
	}

	@GetMapping("/findAllUsers")
	public List<EmpUser> findAllUsers() {
		return userService.findAll();
	}

	@PutMapping("/updateUser")
	public void updateUser(int id, String userName, String password, String roleName) {
		userService.updateUser(id, userName, password, roleName);
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(int id) {
		userService.deleteById(id);
	}
}
