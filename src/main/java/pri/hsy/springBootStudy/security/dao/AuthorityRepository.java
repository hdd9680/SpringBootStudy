package pri.hsy.springBootStudy.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pri.hsy.springBootStudy.member.entity.Authority;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {

}
