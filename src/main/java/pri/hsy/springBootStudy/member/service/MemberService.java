package pri.hsy.springBootStudy.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pri.hsy.springBootStudy.comm.exception.CustomExceptionFactory;
import pri.hsy.springBootStudy.member.dao.AuthorityRepository;
import pri.hsy.springBootStudy.member.dao.MemberRepository;
import pri.hsy.springBootStudy.member.dao.RoleRepository;
import pri.hsy.springBootStudy.member.dto.AuthorityDto;
import pri.hsy.springBootStudy.member.dto.MemberDto;
import pri.hsy.springBootStudy.member.dto.RoleDto;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final RoleRepository roleRepository;
	private final AuthorityRepository authorityRepository;
	
	@Transactional
	public void saveMember(MemberDto member) {
		
		if(member == null) {
			throw CustomExceptionFactory.unvalidData("회원 정보가");
		}
		
		memberRepository.save(member);
	}
	
	@Transactional
	public void deleteMember(String id) {
		memberRepository.deleteById(id);
	}
	
	@Transactional
	public MemberDto findMemberById(String id) {
		return memberRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public List<MemberDto> findAllMember() {
		return memberRepository.findAll();
	}
	
	@Transactional
	public void saveRole(RoleDto role) {
		
		if(role.getRoleId() == null) {
			throw CustomExceptionFactory.unvalidData("회원과 권한 정보가");
		}
		
		if(findMemberById(role.getRoleId().getId()) == null) {
			throw CustomExceptionFactory.unvalidData("회원 정보가");
		}
		
		if(findAuthorityById(role.getRoleId().getCode()) == null) {
			throw CustomExceptionFactory.unvalidData("권한 정보가");
		}
		
		roleRepository.save(role);
	}
	
	@Transactional
	public void deleteRole(RoleDto.RoleId roleId) {
		roleRepository.deleteById(roleId);
	}
	
	@Transactional
	public RoleDto findRoleById(RoleDto.RoleId roleId) {
		
		if(roleId == null) {
			throw CustomExceptionFactory.unvalidData("회원 권한 정보가");
		}
		
		return roleRepository.findById(roleId).orElse(null);
	}
	
	@Transactional
	public List<RoleDto> findAllRole() {
		return roleRepository.findAll();
	}
	
	@Transactional
	public List<RoleDto> findRoleByRoleId(String id) {
		return roleRepository.findRoleByRoleId(id);
	}
	
	@Transactional
	public List<RoleDto> findRoleByRoleCode(String code) {
		return roleRepository.findRoleByRoleCode(code);
	}
	
	@Transactional
	public void saveAuthority(AuthorityDto authority) {
		
		if(authority == null) {
			throw CustomExceptionFactory.unvalidData("권한 정보가");
		}
		
		authorityRepository.save(authority);
	}
	
	@Transactional
	public void deleteAuthority(String code) {
		authorityRepository.deleteById(code);
	}
	
	@Transactional
	public AuthorityDto findAuthorityById(String code) {
		return authorityRepository.findById(code).orElse(null);
	}
	
	@Transactional
	public List<AuthorityDto> findAllAuthority() {
		return authorityRepository.findAll();
	}
	
}
