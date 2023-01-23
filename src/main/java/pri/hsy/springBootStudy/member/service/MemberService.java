package pri.hsy.springBootStudy.member.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pri.hsy.springBootStudy.member.dao.MemberDao;
import pri.hsy.springBootStudy.member.dto.MemberDto;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberDao memberDao;
	
	@Transactional
	public void registerMember(MemberDto member) {
		memberDao.registerMember(member);
	}
	
	
}
