package leon.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.springboot.restapi.model.EmpRole;
import leon.springboot.restapi.repository.EmpRoleRepository;

@Service
public class EmpRoleServiceImpl implements EmpRoleService {

	@Autowired
	private EmpRoleRepository roleRepo;

	public void addRole(String roleName) {
		EmpRole role = new EmpRole(roleName);
		roleRepo.save(role);
	}

	@Override
	public List<EmpRole> findAll() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		roleRepo.deleteById(id);
	}

	@Override
	public void updateById(int id, String name) {
		// TODO Auto-generated method stub
		EmpRole role = roleRepo.findById(id).get();
		role.setId(id);
		role.setRoleName(name);
		roleRepo.save(role);
	}
}
