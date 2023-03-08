package pri.hsy.springBootStudy.security.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@ToString(exclude = "childDepartment")
@Entity(name = "DEPARTMENT")
@Table(name = "DEPARTMENT")
public class DepartmentEntity extends CommEntity {
	
	@Id
	private String code;
	
	@Column
	private String parentCode;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parentCode", referencedColumnName = "code", insertable = false, updatable = false)
	private DepartmentEntity parent;
	
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DepartmentEntity> childDepartment = new ArrayList<>();
	
}
