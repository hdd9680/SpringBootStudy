package pri.hsy.springBootStudy.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pri.hsy.springBootStudy.member.dto.AuthorityDto;

public interface AuthorityRepository extends JpaRepository<AuthorityDto, String> {

}
