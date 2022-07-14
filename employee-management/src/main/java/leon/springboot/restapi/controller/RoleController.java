package leon.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import leon.springboot.restapi.model.EmpRole;
import leon.springboot.restapi.service.EmpRoleService;

@RestController
public class RoleController {

	@Autowired
	private EmpRoleService roleService;

	@PostMapping("/addRole")
	public void addRole(String roleName) {
		roleService.addRole(roleName);
	}

	@GetMapping("/findAllRoles")
	public List<EmpRole> findAllRoles() {
		return roleService.findAll();
	}

	@DeleteMapping("/deleteRoleById")
	public void deleteById(int id) {
		roleService.deleteById(id);
	}

	@PutMapping("/updateRoleById")
	public void updateById(int id, String name) {
		roleService.updateById(id, name);
	}
}
