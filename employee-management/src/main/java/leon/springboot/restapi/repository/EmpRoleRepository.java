package leon.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leon.springboot.restapi.model.EmpRole;

@Repository
public interface EmpRoleRepository extends JpaRepository<EmpRole, Integer> {

}
