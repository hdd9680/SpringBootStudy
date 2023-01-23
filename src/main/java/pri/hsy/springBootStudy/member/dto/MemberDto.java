package pri.hsy.springBootStudy.member.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MEMBER")
public class MemberDto {
	
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
	@Column
	private LocalDateTime regDt;
	@Column
	private String registrar;
	@Column
	private LocalDateTime modifyDt;
	@Column
	private String modifier;
	
}
