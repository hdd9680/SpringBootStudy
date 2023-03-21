package pri.hsy.springBootStudy.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class SecurityService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final AuthorityRepository authorityRepository;
	
	
	public List<UserDto> findUserAll() {
		return userRepository.findAll().stream().map(UserDto::of).toList();
	}
	
	public List<RoleDto> findRoleAll() {
		return roleRepository.findAll().stream().map(RoleDto::of).toList();
	}
	
	public List<AuthorityDto> findAuthorityAll() {
		return authorityRepository.findAll().stream().map(AuthorityDto::of).toList();
	}
	
	public RoleDto findRole(String id, String code) {
		return RoleDto.of(findRoleEntity(id, code));
	}
	
	public void deleteRole(String id, String code) {
		roleRepository.deleteById(new RoleEntity.RolePk(id, code));
	}
	
	public void deleteAuthority(String code) {
		authorityRepository.deleteById(code);
	}
	
	public UserDto findUser(String id) {
		return UserDto.of(findUserEntity(id));
	}
	
	private void saveUserEntity(UserEntity user) {
		userRepository.save(user);
	}
	
	private UserEntity findUserEntity(String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	private void saveRoleEntity(RoleEntity role) {
		roleRepository.save(role);
	}
	
	private RoleEntity findRoleEntity(String id, String code) {
		return roleRepository.findByIdAndCode(id, code);
	}
	
	private void saveAuthorityEntity(AuthorityEntity authority) {
		authorityRepository.save(authority);
	}
	
	private AuthorityEntity findAuthorityEntity(String id) {
		return authorityRepository.findById(id).orElse(null);
	}
}
