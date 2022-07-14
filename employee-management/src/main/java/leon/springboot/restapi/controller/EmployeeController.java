package leon.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import leon.springboot.restapi.model.Employee;
import leon.springboot.restapi.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/findAllEmployees")
	public List<Employee> findAllEmployees() {
		return empService.findAll();
	}

	@GetMapping("/findEmpById")
	public Employee findEmpById(int id) {
		return empService.findEmpById(id);
	}

	@PostMapping("/addEmployee")
	public void addEmployee(String firstName, String lastname, String email) {
		empService.addEmployee(firstName, lastname, email);
	}

	@PutMapping("/updateEmployee")
	public void updateEmployeeBy(int id, String firstName, String lastname, String email) {
		empService.updateEmployeeBy(id, firstName, lastname, email);
	}

	@DeleteMapping("/deleteEmpById")
	public void deleteEmpById(int id) {
		empService.deleteEmpById(id);
	}

	@GetMapping("/findByFirstName")
	public List<Employee> findByFirstName(String firstName) {
		return empService.findByFirstName(firstName);
	}

	@GetMapping("/findEmpSortedByFirstNameAndDirection")
	public List<Employee> findEmpSortedByFirstNameAndDirection(Direction direction) {
		return empService.findEmpSortedByFirstNameAndDirection(direction);

	}
}
