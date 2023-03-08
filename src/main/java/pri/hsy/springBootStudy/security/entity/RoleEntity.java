package pri.hsy.springBootStudy.member.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pri.hsy.springBootStudy.comm.entity.CommEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "ROLE")
@Table(name = "ROLE")
@IdClass(Role.RolePk.class)
public class Role extends CommEntity {
	
	@Id
	private String id;
	
	@Id
	private String code;
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class RolePk implements Serializable {

		private static final long serialVersionUID = -996482349917884102L;

		@Column
		private String id;
		
		@Column
		private String code;
		
	}
}
