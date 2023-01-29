package pri.hsy.springBootStudy;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class CommDto {
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regDt;
	@Column(updatable = false)
	private String registrar;
	
	@Column
	private LocalDateTime modifyDt;
	@Column
	private String modifier;
}
