package pri.hsy.springBootStudy.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, RoleEntity.RolePk> {
	
	@Query("SELECT r FROM ROLE r LEFT JOIN FETCH r.authority WHERE r.id = :id AND r.code = :code")
	RoleEntity findByIdAndCode(@Param(value = "id") String id, @Param(value = "code") String code);
//	Optional<RoleEntity> findById(@Param(value = "rolePk")RoleEntity.RolePk rolePk);
	
//	@Query("SELECT r FROM ROLE r LEFT JOIN FETCH r.code WHERE r.id = :id")
//	public List<RoleEntity> findRoleByRoleId(@Param(value = "id") String id);
//	
//	@Query("SELECT r FROM ROLE r LEFT JOIN FETCH r.code WHERE r.code = :code")
//	public List<RoleEntity> findRoleByRoleCode(@Param(value = "code") String code);
//	
//	@Query("SELECT r FROM ROLE R LEFT JOIN FETCH r.code")
//	public List<RoleEntity> findAll();
	
}
