package pri.hsy.springBootStudy.member.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.CommDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "roles")
@Entity(name = "MEMBER")
@Table(name = "MEMBER")
public class MemberDto extends CommDto {
	
	@Id
	private String id;
	
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String birthDay;
	@Column
	private String phone;
	@Column
	private String gender;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<RoleDto> roles;
	
}
