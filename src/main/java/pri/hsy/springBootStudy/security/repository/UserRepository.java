package pri.hsy.springBootStudy.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query("SELECT m FROM MEMBER m LEFT JOIN FETCH m.roles WHERE m.id = :id")
	Optional<UserEntity> findById(@Param(value = "id") String id);
	
	@Query("SELECT m FROM MEMBER m LEFT JOIN FETCH m.roles")
	List<UserEntity> findAll();
}
