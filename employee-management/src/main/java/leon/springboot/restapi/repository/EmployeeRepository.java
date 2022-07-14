package leon.springboot.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leon.springboot.restapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByFirstName(String firstName);

}
