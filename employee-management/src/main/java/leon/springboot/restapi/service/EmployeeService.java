package leon.springboot.restapi.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import leon.springboot.restapi.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findEmpById(int id);

	public void addEmployee(String firstName, String lastname, String email);

	public void updateEmployeeBy(int id, String firstName, String lastname, String email);

	public void deleteEmpById(int id);

	public List<Employee> findEmpSortedByFirstNameAndDirection(Direction direction);

	public List<Employee> findByFirstName(String firstName);

}
