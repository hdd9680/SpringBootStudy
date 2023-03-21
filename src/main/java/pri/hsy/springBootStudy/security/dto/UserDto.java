package pri.hsy.springBootStudy.security.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.security.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "roles")
public class UserDto {
	
	private String id;
	private String password;
	private String name;
	private String birthDay;
	private String phone;
	private String gender;
	
	private List<RoleDto> roles;
	
	public UserEntity to() {
		return UserEntity.builder()
			.id(id)
			.password(password)
			.name(name)
			.birthDay(birthDay)
			.phone(phone)
			.gender(gender)
			.build();
	}
	
	public static UserDto of(UserEntity member) {
		return UserDto.builder()
				.id(member.getId())
				.password(member.getPassword())
				.name(member.getName())
				.birthDay(member.getBirthDay())
				.phone(member.getPhone())
				.gender(member.getGender())
				.roles(member.getRoles().stream().map(RoleDto::of).toList())
				.build();
	}
	
}
