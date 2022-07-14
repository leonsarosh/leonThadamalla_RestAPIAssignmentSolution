package leon.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import leon.springboot.restapi.model.Employee;
import leon.springboot.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findEmpById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public void addEmployee(String firstName, String lastname, String email) {
		// TODO Auto-generated method stub
		Employee employee = new Employee(firstName, lastname, email);
		empRepo.saveAndFlush(employee);
	}

	@Override
	public void updateEmployeeBy(int id, String firstName, String lastname, String email) {
		// TODO Auto-generated method stub
		Employee updatedEmployee = empRepo.findById(id).get();
		updatedEmployee.setFirstName(firstName);
		updatedEmployee.setLastname(lastname);
		updatedEmployee.setEmail(email);
		empRepo.saveAndFlush(updatedEmployee);
	}

	@Override
	public void deleteEmpById(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

	@Override
	public List<Employee> findEmpSortedByFirstNameAndDirection(Direction direction) {
		// TODO Auto-generated method stub
		return empRepo.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return empRepo.findByFirstName(firstName);
	}
}
