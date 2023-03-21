package pri.hsy.springBootStudy.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query("SELECT u FROM USER u LEFT JOIN FETCH u.roles WHERE u.id = :id")
	Optional<UserEntity> findById(@Param(value = "id") String id);
	
	@Query("SELECT u FROM USER u LEFT JOIN FETCH u.roles")
	List<UserEntity> findAll();
}
