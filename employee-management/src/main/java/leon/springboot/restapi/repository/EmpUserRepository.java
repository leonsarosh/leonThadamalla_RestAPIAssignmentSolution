package leon.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leon.springboot.restapi.model.EmpUser;

@Repository
public interface EmpUserRepository extends JpaRepository<EmpUser, Integer> {

	public EmpUser findByUserName(String userName);

}
