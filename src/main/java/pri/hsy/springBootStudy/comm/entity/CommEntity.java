package pri.hsy.springBootStudy.comm.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class CommEntity {
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regDt;
	@Column(updatable = false)
	private String registrar;
	
	@LastModifiedDate
	@Column
	private LocalDateTime modifyDt;
	@Column
	private String modifier;
}
