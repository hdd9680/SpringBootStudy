package pri.hsy.springBootStudy.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pri.hsy.springBootStudy.security.dto.AuthorityDto;
import pri.hsy.springBootStudy.security.dto.RoleDto;
import pri.hsy.springBootStudy.security.dto.UserDto;
import pri.hsy.springBootStudy.security.entity.AuthorityEntity;
import pri.hsy.springBootStudy.security.entity.RoleEntity;
import pri.hsy.springBootStudy.security.entity.UserEntity;
import pri.hsy.springBootStudy.security.repository.AuthorityRepository;
import pri.hsy.springBootStudy.security.repository.RoleRepository;
import pri.hsy.springBootStudy.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class SecurityService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final AuthorityRepository authorityRepository;
	
	
	private void saveUser(UserDto user) {
		userRepository.save(user.to());
	}
	
	private void deleteUser(UserEntity user) {
		userRepository.delete(user);
	}
	
	private UserEntity findUserById(Long uid) {
		return userRepository.findById(uid).orElse(null);
	}
	
	private List<UserEntity> findUserAll() {
		return userRepository.findAll();
	}
	
	private void saveRole(RoleDto role) {
		roleRepository.save(role.to());
	}
	
	private void deleteRole(RoleEntity role) {
		roleRepository.delete(role);
	}
	
	private RoleEntity findRoleById(Long uid) {
		return roleRepository.findById(uid).orElse(null);
	}
	
	private List<RoleEntity> findRoleAll() {
		return roleRepository.findAll();
	}
	
	private void saveAuthority(AuthorityDto authority) {
		authorityRepository.save(authority.to());
	}
	
	private void deleteAuthority(AuthorityEntity authority) {
		authorityRepository.delete(authority);
	}
	
	private AuthorityEntity findAuthorityById(Long uid) {
		return authorityRepository.findById(uid).orElse(null);
	}
	
	private List<AuthorityEntity> findAuthorityAll() {
		return authorityRepository.findAll();
	}

}
