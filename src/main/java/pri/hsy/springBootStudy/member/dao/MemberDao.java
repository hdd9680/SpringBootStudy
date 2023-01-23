package pri.hsy.springBootStudy.member.dao;

import java.lang.reflect.Member;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import pri.hsy.springBootStudy.member.dto.MemberDto;

@Repository
@RequiredArgsConstructor
public class MemberDao {
	
	@PersistenceContext
	private final EntityManager em;
	
	
	public void registerMember(MemberDto member) {
		em.persist(member);
	}
	
}
