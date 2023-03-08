package pri.hsy.springBootStudy.member.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pri.hsy.springBootStudy.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query("SELECT m FROM MEMBER m LEFT JOIN FETCH m.roles WHERE m.id = :id")
	Optional<Member> findById(@Param(value = "id") String id);
	
	@Query("SELECT m FROM MEMBER m LEFT JOIN FETCH m.roles")
	List<Member> findAll();
}
