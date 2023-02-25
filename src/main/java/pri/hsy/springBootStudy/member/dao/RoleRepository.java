package pri.hsy.springBootStudy.member.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.member.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Role.RolePk> {
	
	@Query("SELECT r FROM ROLE r WHERE r.id = :id")
	public List<Role> findRoleByRoleId(@Param(value = "id") String id);
	
	@Query("SELECT r FROM ROLE r WHERE r.code = :code")
	public List<Role> findRoleByRoleCode(@Param(value = "code") String code);
	
}
