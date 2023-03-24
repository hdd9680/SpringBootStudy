package pri.hsy.springBootStudy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT u FROM USER u LEFT JOIN FETCH u.roles WHERE u.uid = :uid")
	Optional<UserEntity> findById(@Param("uid") Long uid);
	
}
