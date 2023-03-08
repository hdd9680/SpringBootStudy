package pri.hsy.springBootStudy.member.entity;

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
import pri.hsy.springBootStudy.comm.entity.CommEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "AUTHORITY")
@Table(name = "AUTHORITY")
public class Authority extends CommEntity {
	
	@Id
	private String code;
	
	@Column
	private String name;
	@Column
	private String description;
	
}
