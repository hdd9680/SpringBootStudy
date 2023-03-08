package pri.hsy.springBootStudy.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.member.entity.Authority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthorityDto {
	
	private String code;
	private String name;
	private String description;
	
	public Authority to() {
		return Authority.builder()
				.code(code)
				.name(name)
				.description(description)
				.build();
	}
	
	public static AuthorityDto of(Authority authority) {
		return AuthorityDto.builder()
				.code(authority.getCode())
				.name(authority.getName())
				.description(authority.getDescription())
				.build();
	}
	
}
