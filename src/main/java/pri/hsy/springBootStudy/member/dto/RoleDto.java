package pri.hsy.springBootStudy.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.member.entity.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoleDto {
	
	private String id;
	private String code;
	
	public Role to() {
		return Role.builder()
				.id(id)
				.code(code)
				.build();
	}
	
	public static RoleDto of(Role role) {
		return RoleDto.builder()
				.id(role.getId())
				.code(role.getCode())
				.build();
	}
	
}
