package pri.hsy.springBootStudy.member.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@Entity(name = "ROLE")
@Table(name = "ROLE")
public class RoleDto extends CommDto {
	
	@EmbeddedId
	private RoleId roleId;
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Embeddable
	@EqualsAndHashCode
	public static class RoleId implements Serializable {

		private static final long serialVersionUID = -996482349917884102L;

		@Column
		private String id;
		
		@Column
		private String code;
		
	}
	
}
