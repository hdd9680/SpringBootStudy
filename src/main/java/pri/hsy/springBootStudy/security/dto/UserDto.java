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
	
	private Long uid;
	private String email;
	private String password;
	private String name;
	private String birthDay;
	private String phone;
	private String gender;
	
	private List<RoleDto> roles;
	
	public UserEntity to() {
		return UserEntity.builder()
			.uid(uid)
			.email(email)
			.password(password)
			.name(name)
			.birthDay(birthDay)
			.phone(phone)
			.gender(gender)
			.roles(roles.stream().map(RoleDto::to).toList())
			.build();
	}
	
	public static UserDto of(UserEntity user) {
		return UserDto.builder()
				.uid(user.getUid())
				.email(user.getEmail())
				.password(user.getPassword())
				.name(user.getName())
				.birthDay(user.getBirthDay())
				.phone(user.getPhone())
				.gender(user.getGender())
				.roles(user.getRoles().stream().map(RoleDto::of).toList())
				.build();
	}
	
}
