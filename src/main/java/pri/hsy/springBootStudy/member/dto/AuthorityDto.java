package pri.hsy.springBootStudy.member.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@ToString
@Entity(name = "AUTHORITY")
@Table(name = "AUTHORITY")
public class AuthorityDto extends CommDto {
	
	@Id
	private String code;
	
	@Column
	private String name;
	@Column
	private String desc;
	
}
