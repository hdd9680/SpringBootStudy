package pri.hsy.springBootStudy.member.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pri.hsy.springBootStudy.member.dto.MemberDto;

@Repository
public interface MemberRepository extends JpaRepository<MemberDto, String> {

	@Query("SELECT m FROM MEMBER m LEFT JOIN FETCH m.roles WHERE m.id = :id")
	Optional<MemberDto> findById(@Param(value = "id") String id);
	
}
