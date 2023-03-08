package pri.hsy.springBootStudy.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.member.entity.RoleEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoleDto {
	
	private String id;
	private String code;
	
	public RoleEntity to() {
		return RoleEntity.builder()
				.id(id)
				.code(code)
				.build();
	}
	
	public static RoleDto of(RoleEntity role) {
		return RoleDto.builder()
				.id(role.getId())
				.code(role.getCode())
				.build();
	}
	
}
