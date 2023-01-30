package pri.hsy.springBootStudy.member.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pri.hsy.springBootStudy.member.dto.RoleDto;

@Repository
public interface RoleRepository extends JpaRepository<RoleDto, RoleDto.RoleId> {
	
	@Query("SELECT r FROM ROLE r WHERE r.roleId.id = :id")
	public List<RoleDto> findRoleByRoleId(@Param(value = "id") String id);
	
	@Query("SELECT r FROM ROLE r WHERE r.roleId.code = :code")
	public List<RoleDto> findRoleByRoleCode(@Param(value = "code") String code);
	
}
