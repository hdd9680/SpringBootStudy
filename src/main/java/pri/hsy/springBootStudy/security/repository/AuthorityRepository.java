package pri.hsy.springBootStudy.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pri.hsy.springBootStudy.security.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {

}
