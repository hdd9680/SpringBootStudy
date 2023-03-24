package pri.hsy.springBootStudy.security.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.security.entity.AuthorityEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthorityDto {
	
	private Long uid;
	private String code;
	private String name;
	private String description;
	
	private List<RoleDto> roles;
	
	public AuthorityEntity to() {
		return AuthorityEntity.builder()
				.uid(uid)
				.code(code)
				.name(name)
				.description(description)
				.roles(roles.stream().map(RoleDto::to).toList())
				.build();
	}
	
	public static AuthorityDto of(AuthorityEntity authority) {
		return AuthorityDto.builder()
				.uid(authority.getUid())
				.code(authority.getCode())
				.name(authority.getName())
				.description(authority.getDescription())
				.roles(authority.getRoles().stream().map(RoleDto::of).toList())
				.build();
	}
	
}
