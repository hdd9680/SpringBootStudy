package pri.hsy.springBootStudy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	@Query("SELECT r FROM ROLE r LEFT JOIN FETCH r.authority WHERE r.uid = :uid")
	Optional<RoleEntity> findById(@Param("uid")Long uid);
	
}
