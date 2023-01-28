package pri.hsy.springBootStudy.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pri.hsy.springBootStudy.member.dao.MemberRepository;
import pri.hsy.springBootStudy.member.dto.MemberDto;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Transactional
	public void registerMember(MemberDto member) {
		memberRepository.save(member);
	}
	
	@Transactional
	public void deleteMember(String id) {
		memberRepository.deleteById(id);
	}
	
	@Transactional
	public MemberDto findMemberById(String id) {
		
		Optional<MemberDto> memberOption = memberRepository.findById(id);
		
		return memberOption.isEmpty() ? null : memberOption.get();
	}
	
	@Transactional
	public List<MemberDto> findAllMember() {
		return memberRepository.findAll();
	}
	
	
}
