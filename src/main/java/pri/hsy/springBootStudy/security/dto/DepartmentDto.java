package pri.hsy.springBootStudy.security.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pri.hsy.springBootStudy.member.entity.DepartmentEntity;

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
	
	public DepartmentEntity to() {
		return DepartmentEntity.builder()
				.code(code)
				.parentCode(parentCode)
				.name(name)
				.description(description)
				.childDepartment(childDepartment.stream().map(DepartmentDto::to).toList())
				.build();
	}
	
	public static DepartmentDto of(DepartmentEntity department) {
		return DepartmentDto.builder()
				.code(department.getCode())
				.parentCode(department.getParentCode())
				.parent(DepartmentDto.of(department.getParent()))
				.name(department.getName())
				.description(department.getDescription())
				.build();
	}
}
