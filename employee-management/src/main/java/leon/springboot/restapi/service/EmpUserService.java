package leon.springboot.restapi.service;

import java.util.List;

import leon.springboot.restapi.model.EmpUser;

public interface EmpUserService {

	void addEmpUser(String userName, String password, String roleName);

	List<EmpUser> findAll();

	void updateUser(int id, String userName, String password, String roleName);

	void deleteById(int id);

	public String passwordencode(String password);

}
