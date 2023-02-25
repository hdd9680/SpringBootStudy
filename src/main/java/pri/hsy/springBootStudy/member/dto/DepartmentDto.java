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
import pri.hsy.springBootStudy.member.entity.Department;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
	
	private String code;
	private String parentCode;
	private DepartmentDto parent;
	private String name;
	private String description;
	private List<DepartmentDto> childDepartment;
	
	public Department to() {
		return Department.builder()
				.code(code)
				.parentCode(parentCode)
				.name(name)
				.description(description)
				.childDepartment(childDepartment.stream().map(DepartmentDto::to).toList())
				.build();
	}
	
	public static DepartmentDto of(Department department) {
		return DepartmentDto.builder()
				.code(department.getCode())
				.parentCode(department.getParentCode())
				.parent(DepartmentDto.of(department.getParent()))
				.name(department.getName())
				.description(department.getDescription())
				.build();
	}
}
