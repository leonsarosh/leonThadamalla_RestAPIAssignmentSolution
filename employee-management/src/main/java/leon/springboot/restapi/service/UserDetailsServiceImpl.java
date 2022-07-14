package leon.springboot.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import leon.springboot.restapi.model.EmpUser;
import leon.springboot.restapi.repository.EmpUserRepository;
import leon.springboot.restapi.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmpUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		EmpUser user = userRepo.findByUserName(userName);
		if (user==null) {
			throw new UsernameNotFoundException("Username" + userName + " not found");
		}
		
		MyUserDetails myUserDetails = new MyUserDetails(user);
		return myUserDetails;
	}

}
