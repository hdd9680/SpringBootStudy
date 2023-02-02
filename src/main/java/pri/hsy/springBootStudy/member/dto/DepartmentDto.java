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
import pri.hsy.springBootStudy.comm.dto.CommDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "childDepartment")
@Entity(name = "DEPARTMENT")
@Table(name = "DEPARTMENT")
public class DepartmentDto extends CommDto {
	
	@Id
	private String code;
	
	@Column
	private String parentCode;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parentCode", referencedColumnName = "code")
	private List<DepartmentDto> childDepartment;
	
}
