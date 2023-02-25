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
import pri.hsy.springBootStudy.member.entity.Authority;
import pri.hsy.springBootStudy.member.entity.Member;
import pri.hsy.springBootStudy.member.entity.Role;

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
		
		memberRepository.save(member.to());
	}
	
	@Transactional
	public void deleteMember(String id) {
		memberRepository.deleteById(id);
	}
	
	@Transactional
	public MemberDto findMemberById(String id) {
		
		Member member = memberRepository.findById(id).orElse(null);
		
		if(member == null) {
			return null;
		}
		
		return MemberDto.of(member);
	}
	
	@Transactional
	public List<MemberDto> findAllMember() {
		
		List<Member> memberList = memberRepository.findAll();
		
		return memberList.stream().map(MemberDto::of).toList();
	}
	
	@Transactional
	public void saveRole(RoleDto role) {
		
		if(findMemberById(role.getId()) == null) {
			throw CustomExceptionFactory.unvalidData("회원 정보가");
		}
		
		if(findAuthorityById(role.getCode()) == null) {
			throw CustomExceptionFactory.unvalidData("권한 정보가");
		}
		
		roleRepository.save(role.to());
	}
	
	@Transactional
	public void deleteRole(RoleDto role) {
		roleRepository.deleteById(Role.RolePk.builder()
												.id(role.getId())
												.code(role.getCode())
												.build());
	}
	
	@Transactional
	public RoleDto findRoleById(RoleDto role) {
		
		if(role == null) {
			throw CustomExceptionFactory.unvalidData("회원 권한 정보가");
		}
		
		Role roleEntity = roleRepository.findById(Role.RolePk.builder()
																.id(role.getId())
																.code(role.getCode())
																.build()).orElse(null);
		
		return RoleDto.of(roleEntity);
	}
	
	@Transactional
	public List<RoleDto> findAllRole() {
		
		List<Role> roleList = roleRepository.findAll();
		
		return roleList.stream().map(RoleDto::of).toList();
	}
	
	@Transactional
	public List<RoleDto> findRoleByRoleId(String id) {
		
		List<Role> roleList = roleRepository.findRoleByRoleId(id);
		
		return roleList.stream().map(RoleDto::of).toList();
	}
	
	@Transactional
	public List<RoleDto> findRoleByRoleCode(String code) {
		
		List<Role> roleList = roleRepository.findRoleByRoleCode(code);
		
		return roleList.stream().map(RoleDto::of).toList();
	}
	
	@Transactional
	public void saveAuthority(AuthorityDto authority) {
		
		if(authority == null) {
			throw CustomExceptionFactory.unvalidData("권한 정보가");
		}
		
		authorityRepository.save(authority.to());
	}
	
	@Transactional
	public void deleteAuthority(String code) {
		authorityRepository.deleteById(code);
	}
	
	@Transactional
	public AuthorityDto findAuthorityById(String code) {
		
		Authority authority = authorityRepository.findById(code).orElse(null);
		
		if(authority == null) {
			return null;
		}
		
		return AuthorityDto.of(authority);
	}
	
	@Transactional
	public List<AuthorityDto> findAllAuthority() {
		
		List<Authority> authorityList = authorityRepository.findAll();
		
		return authorityList.stream().map(AuthorityDto::of).toList();
	}
	
}
