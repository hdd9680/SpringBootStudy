package pri.hsy.springBootStudy.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pri.hsy.springBootStudy.member.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
