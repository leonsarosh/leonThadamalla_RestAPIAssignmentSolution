package leon.springboot.restapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import leon.springboot.restapi.model.EmpRole;
import leon.springboot.restapi.model.EmpUser;
import leon.springboot.restapi.repository.EmpUserRepository;

@Service
public class EmpUserServiceImpl implements EmpUserService {

	@Autowired
	private EmpUserRepository userRepo;

	@Override
	public void addEmpUser(String userName, String password, String roleName) {
		// TODO Auto-generated method stub
		if (roleName == "ADMIN") {
			EmpRole role = new EmpRole(1, roleName);
			Set<EmpRole> roles = new HashSet<>();
			roles.add(role);
			EmpUser newUser = new EmpUser(userName, passwordencode(password), roles);
			userRepo.save(newUser);
		} else {
			EmpRole role = new EmpRole(2, roleName);
			Set<EmpRole> roles = new HashSet<>();
			roles.add(role);
			EmpUser newUser = new EmpUser(userName, passwordencode(password), roles);
			userRepo.save(newUser);
		}
	}

	@Override
	public List<EmpUser> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void updateUser(int id, String userName, String password, String roleName) {
		// TODO Auto-generated method stub
		EmpUser updatedUser = userRepo.findById(id).get();
		if (roleName == "ADMIN") {
			EmpRole role = new EmpRole(1, roleName);
			Set<EmpRole> roles = new HashSet<>();
			roles.add(role);
			updatedUser.setUserName(userName);
			updatedUser.setPassword(passwordencode(password));
			updatedUser.setRoles(roles);
			userRepo.saveAndFlush(updatedUser);
		} else {
			EmpRole role = new EmpRole(2, roleName);
			Set<EmpRole> roles = new HashSet<>();
			roles.add(role);
			updatedUser.setUserName(userName);
			updatedUser.setPassword(passwordencode(password));
			updatedUser.setRoles(roles);
			userRepo.saveAndFlush(updatedUser);
		}

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public String passwordencode(String password) {
		// TODO Auto-generated method stub
				PasswordEncoder encoder = new BCryptPasswordEncoder(12);
				String encodedPassword = encoder.encode(password);
				return encodedPassword;
	}
}

//passwordencode(password)
