package domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners
public class TimeEntity {
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;

}
