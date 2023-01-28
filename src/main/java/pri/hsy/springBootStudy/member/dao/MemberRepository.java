package pri.hsy.springBootStudy.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pri.hsy.springBootStudy.member.dto.MemberDto;

@Repository
public interface MemberRepository extends JpaRepository<MemberDto, String> {
	
}
