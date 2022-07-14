package leon.springboot.restapi.service;

import java.util.List;

import leon.springboot.restapi.model.EmpRole;

public interface EmpRoleService {

	public void addRole(String roleName);

	public List<EmpRole> findAll();

	public void deleteById(int id);

	public void updateById(int id, String name);

}
