package pri.hsy.springBootStudy.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.security.entity.RoleEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoleDto {
	
	private UserDto user;
	private AuthorityDto authority;
	
	public RoleEntity to() {
		return RoleEntity.builder()
				.user(user.to())
				.authority(authority.to())
				.build();
	}
	
	public static RoleDto of(RoleEntity role) {
		return RoleDto.builder()
				.user(UserDto.of(role.getUser()))
				.authority(AuthorityDto.of(role.getAuthority()))
				.build();
	}
	
}
