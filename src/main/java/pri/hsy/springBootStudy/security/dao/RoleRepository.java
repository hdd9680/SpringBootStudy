package pri.hsy.springBootStudy.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, RoleEntity.RolePk> {
	
	@Query("SELECT r FROM ROLE r WHERE r.id = :id")
	public List<RoleEntity> findRoleByRoleId(@Param(value = "id") String id);
	
	@Query("SELECT r FROM ROLE r WHERE r.code = :code")
	public List<RoleEntity> findRoleByRoleCode(@Param(value = "code") String code);
	
}
